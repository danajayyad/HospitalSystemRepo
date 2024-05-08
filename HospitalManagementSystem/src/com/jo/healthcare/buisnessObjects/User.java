package com.jo.healthcare.buisnessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jo.healthcare.logger.MyLogger;

public  class User{
	


	//Data hiding implemented (Encapsulation)
	private String firstName;
	private String lastName;
	private String userName;
	private String mobileNumber;
	private String email;
	private String password;
	private String role;
	
	
	
	
	
	//Constructor 
	public User(String firstName, String lastName, String userName, String mobileNumber, String email, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.role = role;
		setMobileNumber(mobileNumber);
		setEmail(email);
		setPassword(password);
	}
	
	//code reusibilty
	/*public User(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	//	this(firstName, lastName,  userName,  mobileNumber,  email,  password);
	}*/
	
	
	
	public String getUserId(String userName, String password) throws SQLException {
	    String userId = null;
	    try (PreparedStatement stmt = LoginSystem.getConn().prepareStatement("SELECT user_id FROM User WHERE userName = ? AND password = ?")) {
	        stmt.setString(1, userName);
	        stmt.setString(2, password);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            userId = rs.getString("user_id");
	        }
	    }
	    return userId;
	}
	
	
	//setters and getters
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void  setUserName(String userName) {
		this.userName = userName;
		
	}
	
	
	public String getUserName() {
		return userName;
	}

	// set number with constraints
	public boolean setMobileNumber(String mobileNumber) {
		Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
		Matcher matcher = pattern.matcher(mobileNumber); 
		if (matcher.matches()) {
			this.mobileNumber = mobileNumber;
			return true;
		}
		else {
			System.out.println("Phone Number is invalid");
			return false;
		}
	}

	
	public String getMobileNumber() {
		return mobileNumber;
	}

	
	
	// email in standard form
	public boolean setEmail(String email) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) {
			this.email = email;
			return true;
		}
		
		else
		{
			System.out.println("Email Address is invalid");
			return false;
		}

			
	}


	public String getEmail() {
		return email;
	}

	
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getPassword()
	{
		return password;
	}

	

	public String getPasswordTestMethod()
	{
		return password;
	}

	public String getRole() {
		return role;
	}

	
	

	
	

	
	
	
	
}
