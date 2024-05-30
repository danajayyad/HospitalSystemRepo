package com.jo.healthcare.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jo.healthcare.errorHandling.ErrorHandler;

public class MySQLConnection {

    // Private static instance variable
    private static MySQLConnection instance;
    private Connection conn;

    // Private constructor to prevent instantiation from outside
    private MySQLConnection() {
    }

    // Public static method to get the singleton instance
    public static Connection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance.conn;
    }

    // Method to connect to MySQL database
    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hospitaldb?" +
                    "user=root&password=12345678");

            System.out.println("Connected!");
        } catch (SQLException ex) {
            new ErrorHandler("An error occurred establishing the connection " + ex.getMessage(), ex);
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed!");
            }
        } catch (SQLException ex) {
            new ErrorHandler("An error occurred while closing the connection " + ex.getMessage(), ex);
        }
    }
}
