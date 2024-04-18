package com.jo.healthcare.services;

import com.jo.healthcare.buisnessObjects.User;
import com.jo.healthcare.logger.MyLogger;

public class UserServices implements UserServicesInterface {

    // Method to change contact details
    public  void changeContactDetails(User user, String mobileNumber, String email) 
    {
        if (user.setEmail(email) && user.setMobileNumber(mobileNumber))
        	 MyLogger.logger.debug("Contact details updated successfully.");
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
        user.setUserName(newUserName);
        MyLogger.logger.info("Username updated successfully.");

    }
}
