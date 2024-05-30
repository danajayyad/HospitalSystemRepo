package com.jo.healthcare.buisnessObjects;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

	List<Appointment> appointments;
	
	public Schedule() {
        this.appointments = new ArrayList<>();
    }
	
	public List<Appointment> getAppointments()
	{
		if(appointments.size()==0)
			System.out.println("Schedule is Empty");
		
		return appointments;
		
	}
	
	
	public void addAppointment(Appointment appointment)
	{
		appointments.add(appointment);
	}
	
	
	public void removeAppointment(Appointment appointment)
	{
		appointments.remove(appointment);
	}
}
