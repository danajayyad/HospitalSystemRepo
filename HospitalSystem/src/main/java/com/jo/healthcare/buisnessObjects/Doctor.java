package com.jo.healthcare.buisnessObjects;


public class Doctor extends User{
	
	private Schedule schedule;
	private Clinic clinic; //Each doctor belongs to one clinic 
	private String specialization; //Each doctor has a schedule
	
	public Doctor(String role,String firstName, String lastName, String userName, String mobileNumber, String email, String password, String specialization){
		super(firstName,  lastName,  userName,  mobileNumber,  email,  password, role);
		this.specialization = specialization;
		schedule = new Schedule();
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getSpecialization() {
        return specialization;
    }
    
    
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
    
    public Clinic getClinic() {
        return clinic;
    }

		
		
		
		
}



