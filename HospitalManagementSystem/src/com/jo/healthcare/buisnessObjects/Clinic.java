package com.jo.healthcare.buisnessObjects;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Doctor> doctors;

    public Clinic(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.setClinic(this); 
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
        doctor.setClinic(null); 
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
    
    
    public void clinicDetails()
    {
    	System.out.println("\nClinic Details:");
    	System.out.println("Name: " + getName());
    	System.out.println("Address: " + getAddress());
    	System.out.println("Phone Number: " + getPhoneNumber());
    	System.out.println("Doctors: " + getDoctors().size());
        
    }
}
