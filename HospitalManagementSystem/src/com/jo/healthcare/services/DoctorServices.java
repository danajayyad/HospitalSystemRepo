package com.jo.healthcare.services;

import java.time.LocalDateTime;
import java.util.List;
import com.jo.healthcare.errorHandling.ErrorHandler;

import com.jo.healthcare.buisnessObjects.*;

public class DoctorServices implements DoctorServicesInterface {
	
	
	
		 public void displayContactDetails(Doctor doctor)
		 {
			
		            UserServices userServices = new UserServices();
		            userServices.displayContactDetails(doctor);
		            System.out.println("Specialization: " + doctor.getSpecialization());
		 }
		 

		
		public  boolean isAvailable(Doctor doctor,LocalDateTime appointmentDateTime)
		{

		
		            List<Appointment> appointments = doctor.getSchedule().getAppointments();
		            for (Appointment appointment : appointments) {
		                LocalDateTime appointmentStartTime = appointment.getAppointmentDateTime();
		                LocalDateTime appointmentEndTime = appointmentStartTime.plusMinutes(appointment.getDuration());
		                if (appointmentDateTime.isBefore(appointmentEndTime) && appointmentDateTime.isAfter(appointmentStartTime)) {
		                    return false;
		                }
		            }
		            return true;
		 }
			
		
		
		public void  cancelAppointment(Doctor doctor,Appointment appointment)
		{
			doctor.getSchedule().removeAppointment(appointment);
		}
		
		
		
		public <Appointement> void printSchedule(Doctor doctor) throws ErrorHandler
		{
			 
			try {
		        for (Appointment appointment : doctor.getSchedule().getAppointments()) {
		            System.out.println(appointment);
		        }
		    } catch (Exception e) {
		        throw new ErrorHandler("Error printing schedule: " + e.getMessage(), e);
		    }
        
    }
		
		
		

}
