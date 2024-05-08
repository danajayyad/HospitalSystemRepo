package com.jo.healthcare.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import com.jo.healthcare.buisnessObjects.Appointment;
import com.jo.healthcare.buisnessObjects.Doctor;
import com.jo.healthcare.buisnessObjects.Patient;
import com.jo.healthcare.errorHandling.ErrorHandler;

public interface PatientServicesInterface {

	public void registerAppointment(LocalDateTime appointmentDateTime, Doctor doctor,Patient patient, String purpose, int duration) throws SQLException;
	
	public void cancelAppointment(Appointment appointment) throws ErrorHandler;
	
}

