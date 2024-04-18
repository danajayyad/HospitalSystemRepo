package com.jo.healthcare.services;

import java.time.LocalDateTime;
import com.jo.healthcare.buisnessObjects.Appointment;
import com.jo.healthcare.buisnessObjects.Doctor;
import com.jo.healthcare.buisnessObjects.Patient;

public interface PatientServicesInterface {

	public void registerAppointment(LocalDateTime appointmentDateTime, Doctor doctor,Patient patient, String purpose, int duration);
	
	public void cancelAppointment(Appointment appointment);
}
