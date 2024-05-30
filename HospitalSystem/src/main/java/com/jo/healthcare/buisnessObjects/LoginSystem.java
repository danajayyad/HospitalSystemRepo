package com.jo.healthcare.buisnessObjects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.jo.healthcare.errorHandling.ErrorHandler;
import com.jo.healthcare.logger.MyLogger;
import com.jo.healthcare.main.MySQLConnection;

import java.sql.Statement;


public class LoginSystem {
        
    
    
    
    // Register a new user
    public static void registerUser(User user) {
        try  {
            // Insert user data into the database
        	if(validatePassword(user.getPassword()))
        			{
        		// Insert user data into the database
		        		String insertUserQuery = "INSERT INTO User (firstName, lastName, userName, mobileNumber, email, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
		        		PreparedStatement preparedStatement = MySQLConnection.getInstance().prepareStatement(insertUserQuery, Statement.RETURN_GENERATED_KEYS);

			            preparedStatement.setString(1, user.getFirstName());
			            preparedStatement.setString(2, user.getLastName());
			            preparedStatement.setString(3, user.getUserName());
			            preparedStatement.setString(4, user.getMobileNumber());
			            preparedStatement.setString(5, user.getEmail());
			            preparedStatement.setString(6, hashPassword(user.getPassword()));
			            preparedStatement.setString(7,user.getRole());
			            
			            
			            preparedStatement.executeUpdate();
            
			            

			            // Retrieve the auto-generated user ID
			            int userId;
			            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			            if (generatedKeys.next()) {
			                userId = generatedKeys.getInt(1);
			            } else {
			                throw new SQLException("Inserting user failed, no ID obtained.");
			            }

			            // Insert into the appropriate table based on the user's role
			            if (user instanceof Doctor) {
			                Doctor doctor = (Doctor) user;
			                String insertDoctorQuery = "INSERT INTO Doctor (user_id, specialization) VALUES (?, ?)";
			                PreparedStatement doctorStatement = MySQLConnection.getInstance().prepareStatement(insertDoctorQuery);
			                doctorStatement.setInt(1, userId);
			                doctorStatement.setString(2, doctor.getSpecialization());
			                doctorStatement.executeUpdate();
			            } else if (user instanceof Patient) {
			            	Patient patient = (Patient) user;
			                String insertPatintQuery = "INSERT INTO Patint (user_id) VALUES (?)";
			                PreparedStatement doctorStatement = MySQLConnection.getInstance().prepareStatement(insertPatintQuery);
			                doctorStatement.setInt(1, userId);
			                doctorStatement.executeUpdate();
			            }

	            // Log successful registration
	            MyLogger.logger.info("User registered successfully.");
	        			}
	        	else
	        		MyLogger.logger.info("Password is not valid, please try again.");
			
	        		
	        } catch (SQLException e) {
	            new ErrorHandler("An error occurred while registering the user: " + e.getMessage(), e);
	        }
	    }

    // Login, authentication
    public static User login(String userName, String password) {
        try {
            // Query user data from the database
            String selectUserQuery = "SELECT * FROM User WHERE userName = ? AND password = ?";
            PreparedStatement preparedStatement = MySQLConnection.getInstance().prepareStatement(selectUserQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, hashPassword(password));
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // If user exists and password matches, return the user object
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String mobileNumber = resultSet.getString("mobileNumber");
                String email = resultSet.getString("email");
                
                // Check if the user is a doctor or a patient based on their role
                String role = resultSet.getString("role"); 
                
                if (role.equals("doctor")) {
                    // Create a Doctor object based on the retrieved data
                    Doctor doctor = new Doctor(role,firstName, lastName, userName, mobileNumber, email, password, resultSet.getString("specialization"));
                    return doctor;
                } else if (role.equals("patient")) {
                    // Create a Patient object based on the retrieved data
                    Patient patient = new Patient(role,firstName, lastName, userName, mobileNumber, email, password);
                    return patient;
                }
            } else {
                MyLogger.logger.warn("User not found or incorrect password. Please check your credentials.");
            }
        } catch (SQLException e) {
            new ErrorHandler("An error occurred while logging the user: " + e.getMessage(), e);
        }
        return null; // Login fails
    }


    // Validate password format
    private static boolean validatePassword(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Dummy password hashing
    private static String hashPassword(String password) {
        return password;
    }



	
}
