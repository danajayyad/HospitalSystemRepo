package com.jo.healthcare.services;

import java.time.LocalDateTime;

import com.jo.healthcare.buisnessObjects.Appointment;
import com.jo.healthcare.buisnessObjects.Doctor;
import com.jo.healthcare.buisnessObjects.Patient;
import com.jo.healthcare.errorHandling.ErrorHandler;
import com.jo.healthcare.logger.MyLogger;


public class PatientServices {

	
	public void registerAppointment(LocalDateTime appointmentDateTime, Doctor doctor,Patient patient, String purpose, int duration)
	{
		 DoctorServices doctorServices = new DoctorServices();
	    if (doctorServices.isAvailable(doctor,appointmentDateTime))
	    {
	        Appointment appointment = new Appointment(appointmentDateTime, doctor,patient, purpose, duration);
	        doctor.getSchedule().addAppointment(appointment);
	        MyLogger.logger.info("Appointment set successfully");

	    } 
	    
	    else 
	    	System.out.println("Doctor " + doctor.getFirstName() + " " + doctor.getLastName() + " is not available at the specified time.");
	    
	}
	
	public void cancelAppointment(Appointment appointment) throws ErrorHandler {
	    try {
	        appointment.getDoctor().getSchedule().removeAppointment(appointment);
	    } catch (Exception e) {
	        throw new ErrorHandler("Error cancelling appointment: " + e.getMessage(), e);
	    }
	}
	
	
	
	
}
