package com.jo.healthcare.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jo.healthcare.buisnessObjects.LoginSystem;
import com.jo.healthcare.buisnessObjects.User;
import com.jo.healthcare.logger.MyLogger;

public class UserServices implements UserServicesInterface {

	private Connection conn = LoginSystem.getConn();
	
    // Method to change contact details
    public  void changeContactDetails(User user, String mobileNumber, String email) 
    {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE User SET mobileNumber = ?, email = ? WHERE user_id = ?")) {
            stmt.setString(1, mobileNumber);
            stmt.setString(2, email);
            stmt.setString(3, user.getUserId(user.getUserName() , user.getPassword()));
            stmt.executeUpdate();
            MyLogger.logger.info("Contact details updated successfully.");
            
        } catch (SQLException e) {
			e.printStackTrace();
		}
        

    }

    // Method to display contact details
    public  void  displayContactDetails(User user) 
    {
        System.out.println("Name:  " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Contact Info:");
        System.out.println("Email:  " + user.getEmail());
        System.out.println("Mobile Number:   " + user.getMobileNumber());
    }

    // Method to change username
    public  void changeUserName(User user, String newUserName) 
    {
    	try (PreparedStatement stmt = conn.prepareStatement("UPDATE User SET userName = ? WHERE user_id = ?")) {
            stmt.setString(1, newUserName);
            stmt.setString(2, user.getUserId(user.getUserName() , user.getPassword()));
            stmt.executeUpdate();        
            MyLogger.logger.info("Username updated successfully.");
            
    	} catch (SQLException e) {
			e.printStackTrace();
		}

    }
}
