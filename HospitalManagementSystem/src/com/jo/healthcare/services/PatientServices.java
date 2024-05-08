package com.jo.healthcare.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.jo.healthcare.buisnessObjects.Appointment;
import com.jo.healthcare.buisnessObjects.Doctor;
import com.jo.healthcare.buisnessObjects.LoginSystem;
import com.jo.healthcare.buisnessObjects.Patient;
import com.jo.healthcare.errorHandling.ErrorHandler;
import com.jo.healthcare.logger.MyLogger;


public class PatientServices {

	private Connection conn = LoginSystem.getConn();
	
	public void registerAppointment(LocalDateTime appointmentDateTime, Doctor doctor,Patient patient, String purpose, int duration) throws SQLException
	{
		 DoctorServices doctorServices = new DoctorServices(conn);
		 String doctorId = doctor.getUserId(doctor.getUserName(), doctor.getPassword());
		 
	    if (doctorServices.isAvailable(doctorId,appointmentDateTime))
	    {
			 String patientId = doctor.getUserId(patient.getUserName(), patient.getPassword());

	        Appointment appointment = new Appointment(appointmentDateTime, doctorId,patientId, purpose, duration);
	        doctor.getSchedule().addAppointment(appointment);
	        
	        
	        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO Appointment (appointmentDateTime, doctor_id, patient_id, purpose, duration) VALUES (?, ?, ?, ?, ?)")) {
	            stmt.setObject(1, appointment.getAppointmentDateTime());
	            stmt.setString(2, appointment.getDoctorId());
	            stmt.setString(3, appointment.getPatientId());
	            stmt.setString(4, appointment.getPurpose());
	            stmt.setInt(5, appointment.getDuration());
	            stmt.executeUpdate();
	        }
	        
	        
	        MyLogger.logger.info("Appointment set successfully");

	    } 
	    
	    else 
	    	System.out.println("Doctor " + doctor.getFirstName() + " " + doctor.getLastName() + " is not available at the specified time.");
	    
	}
	
	public void cancelAppointment(Appointment appointment) throws ErrorHandler {
	    try {
	       
	        String appointmentId = appointment.getAppointmentId();
	        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM Appointment WHERE appointment_id = ?")) {
	            stmt.setString(1, appointmentId);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected == 1) {
	                System.out.println("Appointment cancelled successfully.");
	            } else {
	                System.out.println("No appointment found with ID: " + appointmentId);
	            }
	        }
	        
	        
	    } catch (Exception e) {
	        throw new ErrorHandler("Error cancelling appointment: " + e.getMessage(), e);
	    }
	}
	
	
	
	
}
