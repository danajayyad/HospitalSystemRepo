package com.jo.healthcare.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import com.jo.healthcare.buisnessObjects.*;
import com.jo.healthcare.errorHandling.ErrorHandler;



public interface DoctorServicesInterface {
    
	public void displayContactDetails(String userId)throws SQLException;
	
	public boolean isAvailable(String doctorId, LocalDateTime appointmentDateTime) throws SQLException;
    
	public void cancelAppointment(String appointmentId) throws SQLException;
    
	public void printSchedule(String userId) throws SQLException, ErrorHandler;

}
