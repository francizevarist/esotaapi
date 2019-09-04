package com.esotacredit.esotaapi.api.registration;

import com.esotacredit.esotaapi.api.registration.datamodel.RegistrationBody;
import com.esotacredit.esotaapi.api.registration.datamodel.RegistrationResponseBody;
import com.esotacredit.esotaapi.api.registration.edit.editname.EditNameBody;
import com.esotacredit.esotaapi.api.registration.edit.editname.EditNameResponseBody;
import com.esotacredit.esotaapi.api.registration.edit.editnumber.EditPhoneNumberBody;
import com.esotacredit.esotaapi.api.registration.edit.editnumber.EditPhoneNumberResponseBody;
import com.esotacredit.esotaapi.api.registration.edit.object.EditMessage;
import com.esotacredit.esotaapi.database.DatabaseConfiguration;
import com.esotacredit.esotaapi.utils.RandomGenerator;
import com.esotacredit.esotaapi.values.Values;
import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class RegistrationDaoService {

    public RegistrationResponseBody createUser(RegistrationBody registrationBody){
        RegistrationResponseBody registered = null;
        String verificationCode = new RandomGenerator().getVerificationCode();

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            String query_createuser = "INSERT INTO user " +
                    "(id,country_id,phone_number,first_name,last_name,email,verification_code,user_status) \n" +
                    "VALUES (?,?,?,?,?,?,?,?)";

            //save trip
            PreparedStatement preparedStatement = con.prepareStatement(query_createuser);

            preparedStatement.setInt(1, Values.EMPTY_OFF_VALUE);
            preparedStatement.setInt(2,registrationBody.getCountryId());
            preparedStatement.setString(3,registrationBody.getPhoneNumber());
            preparedStatement.setString(4,registrationBody.getFirstName());
            preparedStatement.setString(5,registrationBody.getLastName());
            preparedStatement.setString(6,registrationBody.getEmail());
            preparedStatement.setString(7,verificationCode);
            preparedStatement.setInt(8,Values.EMPTY_OFF_VALUE);
            preparedStatement.execute();

            //get registered user
            String query_getuser = "SELECT * FROM user,country  WHERE user.country_id = country.id AND phone_number ='"+registrationBody.getPhoneNumber()+"' AND user_status="+Values.EMPTY_OFF_VALUE;

            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query_getuser);

            while(rs.next()){
                registered = new RegistrationResponseBody(rs.getInt("id"),rs.getInt("verification_code"),rs.getString("country_code"),rs.getString("phone_number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registered;
    }

    /**
     * Edit User
     */
    EditNameResponseBody editName(EditNameBody editNameBody){
        EditMessage message = null;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //verify user
            String query_verifyuser = "UPDATE user SET first_name = '"+editNameBody.getFirstName()+"', last_name = '"+editNameBody.getLastName()+"' WHERE user.id = '"+editNameBody.getUserId()+"'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query_verifyuser);
            message = new EditMessage("Name Updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new EditNameResponseBody(message);
    }

    /**
     * Change phone Number
     */
    EditPhoneNumberResponseBody editPhoneNumber(EditPhoneNumberBody editPhoneNumberBody){
        EditMessage message = null;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //verify user
            String query_verifyuser = "UPDATE user SET phone_number = '"+editPhoneNumberBody.getPhoneNumber()+"'  WHERE user.id = '"+editPhoneNumberBody.getUserId()+"'  AND  user.country_id='"+editPhoneNumberBody.getCountryId()+"'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query_verifyuser);
            message = new EditMessage("Name Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new EditPhoneNumberResponseBody(message);
    }

}
