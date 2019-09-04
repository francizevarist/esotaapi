package com.esotacredit.esotaapi.api.login;

import com.esotacredit.esotaapi.api.login.datamodel.LoginBody;
import com.esotacredit.esotaapi.api.login.datamodel.LoginResponseBody;
import com.esotacredit.esotaapi.api.registration.datamodel.RegistrationResponseBody;
import com.esotacredit.esotaapi.database.DatabaseConfiguration;
import com.esotacredit.esotaapi.values.Values;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class LoginDaoService {

    public LoginResponseBody login(LoginBody loginBody){

        LoginResponseBody loginResponseBody = null;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            //get registered user
            String query_getuser = "SELECT * FROM user,country  WHERE user.country_id = '"+loginBody.getCountryId()+"' AND phone_number ='"+loginBody.getPhoneNumber()+"' AND user_status="+Values.EMPTY_ACTIVE_VALUE;

            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query_getuser);

            while(rs.next()){
                loginResponseBody = new LoginResponseBody(rs.getInt("id"),rs.getInt("verification_code"),rs.getString("country_code"),rs.getString("phone_number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return loginResponseBody;
    }

}
