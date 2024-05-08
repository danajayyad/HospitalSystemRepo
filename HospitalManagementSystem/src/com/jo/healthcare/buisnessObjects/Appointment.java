package com.jo.healthcare.buisnessObjects;

import java.time.LocalDateTime;



public class Appointment {

	    private LocalDateTime appointmentDateTime;
	    private String appointmentId;
	    private String doctorId;
	    private String patientId;
	    private String appointmentType;
	    private int duration; //in minutes


	    public Appointment(LocalDateTime appointmentDateTime, String doctor_id, String patient_id, String appointmentType, int duration) {
	        this.appointmentDateTime = appointmentDateTime;
	        this.doctorId = doctor_id;
	        this.patientId = patient_id;
	        this.appointmentType = appointmentType;
	        this.duration = duration;
	    }

	 
	    public LocalDateTime getAppointmentDateTime() {
	        return appointmentDateTime;
	    }

	    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
	        this.appointmentDateTime = appointmentDateTime;
	    }

	    public String getDoctorId() {
	        return doctorId;
	    }

	    public void setDoctorId(String doctorId) {
	        this.doctorId = doctorId;
	    }

	    public String getPatientId() {
	        return patientId;
	    }

	    public void setPatient(String patientId) {
	        this.patientId = patientId;
	    }

	    public String getPurpose() {
	        return appointmentType;
	    }

	    public void setPurpose(String appointmentType) {
	        this.appointmentType = appointmentType;
	    }

	    

		public int getDuration() {
			return duration;
		}


		public String getAppointmentId() {
			return appointmentId;
		}


	    
	    
	}


