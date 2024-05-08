package com.jo.healthcare.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import com.jo.healthcare.errorHandling.ErrorHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jo.healthcare.buisnessObjects.*;



public class DoctorServices implements DoctorServicesInterface {
	
	 private Connection conn;
	 
	 public DoctorServices(Connection conn) {
	        this.conn = conn;
	    }
	
	
	
	
	
	public void displayContactDetails(String userId) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Doctor WHERE user_id = ?")) {
	        stmt.setString(1, userId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {

	        	String firstName = rs.getString("firstName");
	            String lastName = rs.getString("lastName");
	            String specialization = rs.getString("specialization");
	            String email = rs.getString("email");
	            String mobileNumber = rs.getString("mobileNumber");

	            // Display doctor's contact details
	            System.out.println("Doctor's Contact Details:");
	            System.out.println("Name: " + firstName + " " + lastName);
	            System.out.println("Specialization: " + specialization);
	            System.out.println("Email: " + email);
	            System.out.println("Mobile Number: " + mobileNumber);
	        }
	    }
	}


		
	public boolean isAvailable(String doctorId, LocalDateTime appointmentDateTime) throws SQLException {
	    try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointment WHERE doctor_id = ? AND appointmentDateTime = ?")) {
	        stmt.setString(1, doctorId);
	        stmt.setString(2, appointmentDateTime.toString());
	        ResultSet rs = stmt.executeQuery();
	        
	        // if appointement exist -> return false
	        return !rs.next();
	    }
	}

			
		
		
	public void cancelAppointment(String appointmentId) throws SQLException {
	    try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM Appointment WHERE appointment_id = ?")) {
	        stmt.setString(1, appointmentId);
	        stmt.executeUpdate();
	    }
	}
		
		
		
	public void printSchedule(String userId) throws SQLException, ErrorHandler {
	    try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Appointment WHERE doctor_id = ?")) {
	        stmt.setString(1, userId);
	        ResultSet rs = stmt.executeQuery();
	        System.out.println("Doctor's Schedule:");
	        while (rs.next()) {
	            String appointmentId = rs.getString("appointment_id");
	            LocalDateTime appointmentDateTime = rs.getObject("appointmentDateTime", LocalDateTime.class);
	            int duration = rs.getInt("duration");
	            System.out.println("Appointment ID: " + appointmentId);
	            System.out.println("Date and Time: " + appointmentDateTime);
	            System.out.println("Duration: " + duration + " minutes");
	        }
	    } catch (SQLException e) {
	        throw new ErrorHandler("Error printing schedule: " + e.getMessage(), e);
	    }
	}

		
		
		

}
