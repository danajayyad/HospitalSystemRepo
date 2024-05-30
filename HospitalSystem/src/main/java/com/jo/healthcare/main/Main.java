package com.jo.healthcare.main;

import java.util.Scanner;

import com.jo.healthcare.buisnessObjects.Appointment;
import com.jo.healthcare.buisnessObjects.Clinic;
import com.jo.healthcare.buisnessObjects.Doctor;
import com.jo.healthcare.buisnessObjects.LoginSystem;
import com.jo.healthcare.buisnessObjects.MedicalRecord;
import com.jo.healthcare.buisnessObjects.Patient;
import com.jo.healthcare.buisnessObjects.Schedule;
import com.jo.healthcare.buisnessObjects.User;

import jakarta.transaction.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    public static void main(String[] args) {
    	
    	User user = new User();
    	Configuration con = new Configuration().configure()
    			.addAnnotatedClass(User.class)
    			.addAnnotatedClass(Doctor.class)
    			.addAnnotatedClass(Appointment.class)
    			.addAnnotatedClass(Clinic.class)
    			.addAnnotatedClass(LoginSystem.class)
    			.addAnnotatedClass(MedicalRecord.class)
    			.addAnnotatedClass(Patient.class)
    			.addAnnotatedClass(Schedule.class);
    	
    	
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(user);
    	
    	tx.commit();
    	

        
        
        
        
        
    }
}
