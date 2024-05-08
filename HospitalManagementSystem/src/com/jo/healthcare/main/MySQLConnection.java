package com.jo.healthcare.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jo.healthcare.errorHandling.ErrorHandler;

public class MySQLConnection {

    public void connect() {
        Connection conn = null;
        
        try {
        	conn = DriverManager.getConnection("jdbc:mysql://localhost/hospitaldb?" +
                    "user=root&password=12345678");

            System.out.println("Connected!");

        } catch (SQLException ex) {

        	System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            new ErrorHandler("An error occurred estaplishing the connection " + ex.getMessage(), ex);
            
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
               new ErrorHandler("An error occurred estaplishing the connection " + ex.getMessage(), ex);
            }
        }
    }
}
