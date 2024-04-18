package com.jo.healthcare.services;

import java.time.LocalDateTime;
import com.jo.healthcare.buisnessObjects.*;
import com.jo.healthcare.errorHandling.ErrorHandler;



public interface DoctorServicesInterface {
    
    void displayContactDetails(Doctor doctor);
    
    boolean isAvailable(Doctor doctor, LocalDateTime appointmentDateTime);
    
    void cancelAppointment(Doctor doctor, Appointment appointment);
    
    public <Appointement> void printSchedule(Doctor doctor) throws ErrorHandler;

}
