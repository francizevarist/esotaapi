package com.esotacredit.esotaapi.api.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.esotacredit.esotaapi.api.profile.credithistory.CreditBody;
import com.esotacredit.esotaapi.api.profile.credithistory.CreditResponseBody;
import com.esotacredit.esotaapi.api.profile.credithistory.object.Credit;
import com.esotacredit.esotaapi.api.profile.withdraw.WithdrawBody;
import com.esotacredit.esotaapi.api.profile.withdraw.WithdrawResponseBody;
import com.esotacredit.esotaapi.api.profile.withdraw.objects.WithdrawMessage;
import com.esotacredit.esotaapi.database.DatabaseConfiguration;
import com.esotacredit.esotaapi.utils.AppTimestamp;
import com.esotacredit.esotaapi.utils.LoadMore;
import com.esotacredit.esotaapi.utils.TransactionIdGenerator;
import com.esotacredit.esotaapi.values.Values;

import org.springframework.stereotype.Component;

@Component
public class ProfileDaoService {

    CreditResponseBody getCreditList(CreditBody creditBody){

        List<Credit> creditList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            String query_credit = "SELECT * FROM  network WHERE credited_user_id = '"+creditBody.getUserId()+"' "+ LoadMore.getPage(creditBody.getPage());

            Statement stmt_credits = con.createStatement();
            ResultSet rs_credits =stmt_credits.executeQuery(query_credit);

            while(rs_credits.next()){
                Credit credit = new Credit(rs_credits.getInt("id"),rs_credits.getString("transaction_id"),rs_credits.getString("joining_time"),rs_credits.getString("credited_time"),rs_credits.getString("credited_amount"));
                creditList.add(credit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new CreditResponseBody(creditList);
    }

    WithdrawResponseBody drawCredit(WithdrawBody withdrawBody){

        String respose = "Transaction Not Completed";
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            float totalCredit = 0;
            float transactionsCompleted = 0;
            float transactionBalance = 0;

            //Get total credit amount from network
            String query_totalcredit = "SELECT sum(credited_amount) AS total_credit FROM  network  WHERE credited_user_id='"+withdrawBody.getUserId()+"'";

            Statement stmt_credits = con.createStatement();
            ResultSet rs_credits =stmt_credits.executeQuery(query_totalcredit);

            while(rs_credits.next()){
                if(rs_credits.getString("total_credit")==null){
                    totalCredit = 0;
                }else {
                    totalCredit = Float.parseFloat(rs_credits.getString("total_credit"));
                }
            }

            //Get total transaction from
            String query_totaltransactions = "SELECT sum(withdraw_amount) AS total_transaction FROM  transaction  WHERE user_id='"+withdrawBody.getUserId()+"'";

            Statement stmt_totalTransactions = con.createStatement();
            ResultSet rs_totalTransactions =stmt_totalTransactions.executeQuery(query_totaltransactions);

            while(rs_totalTransactions.next()){
                if(rs_totalTransactions.getString("total_transaction")==null){
                    transactionsCompleted = 0;
                }else {
                    transactionsCompleted = Float.parseFloat(rs_totalTransactions.getString("total_transaction"));
                }
            }

            //Calculate Transaction Balance
            transactionBalance = totalCredit - transactionsCompleted;


            if (withdrawBody.getAmount()>transactionBalance) {
                respose = "Transaction Fail, You Exceed your Balance Amount";
            }else if(withdrawBody.getAmount() <= 0){
                respose = "Invalid Input, Process halted";
            }
            else {
                String query_createuser = "INSERT INTO transaction " +
                        "(id, user_id,withdraw_amount, transaction_time, transaction_id) \n" +
                        "VALUES (?,?,?,?,?)";

                //save trip
                PreparedStatement preparedStatement = con.prepareStatement(query_createuser);
                preparedStatement.setInt(1, Values.EMPTY_OFF_VALUE);
                preparedStatement.setInt(2, withdrawBody.getUserId());
                preparedStatement.setString(3, Float.toString(withdrawBody.getAmount()));
                preparedStatement.setString(4, String.valueOf(new AppTimestamp().currentTimeStamp()));
                preparedStatement.setString(5, TransactionIdGenerator.getTransactionID());
                preparedStatement.execute();

                respose = "Transaction Completed Successfuly";
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new WithdrawResponseBody(new WithdrawMessage(respose));
    }

    //User Wallet
    public static String getCreditBalance(int userId){

        float balance = 0;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            float totalCredit = 0;
            float transactionsCompleted = 0;

            //Get total credit amount from network
            String query_totalcredit = "SELECT sum(credited_amount) AS total_credit FROM  network  WHERE credited_user_id='"+userId+"'";

            Statement stmt_credits = con.createStatement();
            ResultSet rs_credits =stmt_credits.executeQuery(query_totalcredit);

            while(rs_credits.next()){
                if(rs_credits.getString("total_credit")==null){
                    totalCredit = 0;
                }else {
                    totalCredit = Float.parseFloat(rs_credits.getString("total_credit"));
                }
            }

            //Get total transaction from
            String query_totaltransactions = "SELECT sum(withdraw_amount) AS total_transaction FROM  transaction  WHERE user_id='"+userId+"'";

            Statement stmt_totalTransactions = con.createStatement();
            ResultSet rs_totalTransactions =stmt_totalTransactions.executeQuery(query_totaltransactions);

            while(rs_totalTransactions.next()){
                if(rs_totalTransactions.getString("total_transaction")==null){
                    transactionsCompleted = 0;
                }else {
                    transactionsCompleted = Float.parseFloat(rs_totalTransactions.getString("total_transaction"));
                }
            }

            //Calculate Transaction Balance
            balance = totalCredit - transactionsCompleted;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return String.valueOf(balance);
    }

}
