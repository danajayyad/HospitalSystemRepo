package com.jo.healthcare.buisnessObjects;



public class Patient extends User {
	
	private MedicalRecord medicalRecord = new MedicalRecord();  //Each patient has a medical record 
	
	
	Patient(String role , String firstName, String lastName, String userName, String mobileNumber, String email, String password){
		super(firstName,  lastName,  userName,  mobileNumber,  email,  password, role);
		
	}
	
	
}


