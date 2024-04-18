package com.jo.healthcare.buisnessObjects;

import java.time.LocalDateTime;



public class Appointment {

	    private LocalDateTime appointmentDateTime;
	    private Doctor doctor;
	    private Patient patient;
	    private String appointmentType;
	    private int duration; //in minutes


	    public Appointment(LocalDateTime appointmentDateTime, Doctor doctor, Patient patient, String appointmentType, int duration) {
	        this.appointmentDateTime = appointmentDateTime;
	        this.doctor = doctor;
	        this.patient = patient;
	        this.appointmentType = appointmentType;
	        this.duration = duration;
	    }

	 
	    public LocalDateTime getAppointmentDateTime() {
	        return appointmentDateTime;
	    }

	    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
	        this.appointmentDateTime = appointmentDateTime;
	    }

	    public Doctor getDoctor() {
	        return doctor;
	    }

	    public void setDoctor(Doctor doctor) {
	        this.doctor = doctor;
	    }

	    public Patient getPatient() {
	        return patient;
	    }

	    public void setPatient(Patient patient) {
	        this.patient = patient;
	    }

	    public String getPurpose() {
	        return appointmentType;
	    }

	    public void setPurpose(String appointmentType) {
	        this.appointmentType = appointmentType;
	    }

	    
	    public void displayAppointmentDetails() {
	    	System.out.println("Appointment Date and Time: " + appointmentDateTime);
	    	System.out.println("Doctor: " + doctor.getFirstName() + " " + doctor.getLastName());
	    	System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
	    	System.out.println("Purpose: " + appointmentType);
	    }


		public long getDuration() {
			return duration;
		}


	    
	    
	}


