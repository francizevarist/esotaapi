package com.esotacredit.esotaapi.api.verification;

import com.esotacredit.esotaapi.api.profile.ProfileDaoService;
import com.esotacredit.esotaapi.api.profile.credithistory.object.Credit;
import com.esotacredit.esotaapi.api.registration.datamodel.RegistrationResponseBody;
import com.esotacredit.esotaapi.api.verification.datamodel.UserInformationBody;
import com.esotacredit.esotaapi.api.verification.datamodel.UserInformationResponseBody;
import com.esotacredit.esotaapi.api.verification.datamodel.VerificationBody;
import com.esotacredit.esotaapi.api.verification.datamodel.VerificationResponseBody;
import com.esotacredit.esotaapi.api.verification.objects.*;
import com.esotacredit.esotaapi.database.DatabaseConfiguration;
import com.esotacredit.esotaapi.utils.RandomGenerator;
import com.esotacredit.esotaapi.values.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class VerificationDaoService {

    public VerificationResponseBody verifyUser(VerificationBody verificationBody){

        VerificationResponseBody verified = null;
        User user = null;
        Network network = null;

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //verify user
            String query_verifyuser = "UPDATE user SET user_status = '"+Values.EMPTY_ACTIVE_VALUE+"' WHERE user.id = '"+verificationBody.getUserId()+"'  AND  user.verification_code = '"+verificationBody.getVerificationCode()+"'";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query_verifyuser);

            //get user
            String query_getuser = "SELECT * FROM user,country,currency  WHERE user.id ='"+verificationBody.getUserId()+"' AND verification_code ="+ verificationBody.getVerificationCode()+ " AND  country.currency_id = currency.id";

            Statement stmt_user = con.createStatement();
            ResultSet rs_user =stmt_user.executeQuery(query_getuser);

            while(rs_user.next()){
                user = new User(rs_user.getInt("id"),rs_user.getString("first_name")+" "+rs_user.getString("last_name"),rs_user.getInt("country_id"),rs_user.getString("country_code"),rs_user.getString("country_name"),rs_user.getString("currency_name"),rs_user.getString("currency_abbreviation"),rs_user.getString("phone_number"),new Credits(ProfileDaoService.getCreditBalance(rs_user.getInt("id")),creditProgress(rs_user.getInt("id"))));
                //find user in network
                String query_findUserInNetwork = "SELECT *,COUNT(*) AS usercount FROM network WHERE user_id='"+rs_user.getInt("id")+"'";
                Statement stmt_findUserInNetwork = con.createStatement();
                ResultSet rs_findUserInNetwork =stmt_findUserInNetwork.executeQuery(query_findUserInNetwork);
                while (rs_findUserInNetwork.next()){
                    if(rs_findUserInNetwork.getInt("usercount")>=1){
                        //get network status
                        network = new Network(true);
                    }else {
                        //get network status
                        network = new Network(false);
                    }
                }
            }

            verified = new VerificationResponseBody(user,network);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return verified;
    }


    public static float creditProgress(int userId){

        int userNetworkId = 0;
        int insertedId = 0;
        int milestoneSteps = 0;
        String date;
        float progress = 0f;

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            List<NextCredit> nextCreditList = new ArrayList<>();
            //get Inserted Id
            String query_getInsertedId = "SELECT * FROM  network  ORDER BY id DESC LIMIT 1";
            Statement stmt_insertedId = con.createStatement();
            ResultSet rs_insertedId =stmt_insertedId.executeQuery(query_getInsertedId);

            while (rs_insertedId.next()){
                insertedId = rs_insertedId.getInt("id");
            }

            //get user
            String query_getuser = "SELECT * FROM  network  WHERE user_id ='"+userId+"'";
            Statement stmt_user = con.createStatement();
            ResultSet rs_user =stmt_user.executeQuery(query_getuser);

            /**
             * Predict next payment
             */
            while (rs_user.next()){
                userNetworkId = rs_user.getInt("id");
                milestoneSteps = rs_user.getInt("milestone_steps");
                date = rs_user.getString("joining_time");

                int difference = insertedId - userNetworkId;
                float percent = ((float)difference/(float)milestoneSteps) * 100;
                System.out.println("inserted  id ="+insertedId+ " user network = "+userNetworkId+ " milestone = "+milestoneSteps+" progress ="+percent+" difference ="+difference+"  cal percent ="+((float)((float)difference/(float)milestoneSteps)*100));
                nextCreditList.add(new NextCredit(date,percent));
            }

            for (int i=0; i<nextCreditList.size(); i++){
                float percent = nextCreditList.get(i).getNextCredit();
                System.out.println("percent = "+percent);
                if(percent>=0 && percent<=100){
                    Float roundedPercent = percent;
                    roundedPercent = Float.parseFloat(String.format("%.1f",roundedPercent));
                    progress = roundedPercent;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progress;
    }

    public UserInformationResponseBody userInformation(UserInformationBody userInformationBody){
        UserInformationResponseBody userInfo = null;
        User user = null;
        Network network = null;

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //find user in network
            String query_findUserInNetwork = "SELECT *,COUNT(*) AS usercount FROM network WHERE user_id='"+userInformationBody.getUserId()+"'";
            Statement stmt_findUserInNetwork = con.createStatement();
            ResultSet rs_findUserInNetwork =stmt_findUserInNetwork.executeQuery(query_findUserInNetwork);
            while (rs_findUserInNetwork.next()){
                if(rs_findUserInNetwork.getInt("usercount")>=1){
                    //get network status
                    network = new Network(true);
                }else {
                    //get network status
                    network = new Network(false);
                }
            }

            //get user
            String query_getuser = "SELECT * FROM user,country,currency  WHERE user.id ='"+userInformationBody.getUserId()+"'  AND  country.currency_id = currency.id";

            Statement stmt_user = con.createStatement();
            ResultSet rs_user =stmt_user.executeQuery(query_getuser);

            while(rs_user.next()){
                user = new User(rs_user.getInt("id"),rs_user.getString("first_name")+" "+rs_user.getString("last_name"),rs_user.getInt("country_id"),rs_user.getString("country_code"),rs_user.getString("country_name"),rs_user.getString("currency_name"),rs_user.getString("currency_abbreviation"),rs_user.getString("phone_number"),new Credits(ProfileDaoService.getCreditBalance(userInformationBody.getUserId()),creditProgress(userInformationBody.getUserId())));
            }

            userInfo = new UserInformationResponseBody(user,network);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

}
