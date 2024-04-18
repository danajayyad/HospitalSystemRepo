package com.jo.healthcare.buisnessObjects;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jo.healthcare.errorHandling.ErrorHandler;
import com.jo.healthcare.logger.MyLogger;

public class LoginSystem {
    
    private static Map<String, User> users = new HashMap<>(); //Map to store users
    
    //new user
    public static void registerUser(User user) {
        try {
        	
            if (validatePassword(user.getPassword())) 
            {
            	if (user instanceof Doctor) {
                    users.put(user.getUserName(), user); // Store doctor in the map
                    MyLogger.logger.info("ٌDoctor registered successfully.");
                } 
            	else if (user instanceof Patient) {
                    users.put(user.getUserName(), user); // Store patient in the mapl
                    MyLogger.logger.info("ٌPatient registered successfully.");
                } 
            	else {
            		new ErrorHandler("An error occurred while registering the user" );
            	}
            }
            
            else 
            {
            	new ErrorHandler("Invalid password format." );
            }
            
        } catch (Exception e) {
        	 new ErrorHandler("An error occurred while registering the user: " + e.getMessage(), e);
         }  
        }
    
    
    
    
    //Validate password format
    private static boolean validatePassword(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    
    
    //Dummy password hashing
    private static String hashPassword(String password) {
        return password; 
    }
    
    //Login, authentication
    public static User login(String userName, String password) {
    	 try {
             if (users.containsKey(userName)) {
                 User user = users.get(userName);
                 String hashedPassword = hashPassword(password); // Provide original password
                 if (user.getPassword().equals(hashedPassword))
                 {	 MyLogger.logger.info("Login Successfully");
                  		return user;
                   
                 // Return user if username and hashed password match
                 }
                 else
                     MyLogger.logger.warn("Incorrect password. Please try again.");

             } else
                 MyLogger.logger.warn("User not found. Please check your username or password.");

             
         } 
    	 catch (Exception e) {
    		 new ErrorHandler("An error occurred while logging the user: " + e.getMessage(), e);
        	 
         }
         return null; // Login fails
     }
}
