package com.jo.healthcare.main;

import java.util.Scanner;

import com.jo.healthcare.buisnessObjects.Doctor;
import com.jo.healthcare.buisnessObjects.LoginSystem;
import com.jo.healthcare.buisnessObjects.User;

public class Main {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        // Gather doctor details
        System.out.println("Enter doctor details:");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Username: ");
        String userName = scanner.nextLine();
        System.out.print("Mobile number: ");
        String mobileNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        // new Doctor 
        Doctor doctor = new Doctor(firstName, lastName, userName, mobileNumber, email, password, specialization);

        //Polymorphism
        LoginSystem.registerUser(doctor);
        LoginSystem.login(userName, password);
        System.out.println("TEST");
        System.out.println("TEST");

        
        
        
        
        
    }
}
