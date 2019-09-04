package com.esotacredit.esotaapi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConfiguration {

    private static String DATABASE_URL = "jdbc:mysql://localhost/esotacredit";
    private static String USER = "root";
    private static String PASSWORD = "admin";

    public static Connection getDatabeConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con= null;
        try {
            con = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

}
