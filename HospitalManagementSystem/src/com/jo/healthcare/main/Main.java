package com.jo.healthcare.main;

import java.util.Scanner;

import com.jo.healthcare.buisnessObjects.Doctor;
import com.jo.healthcare.buisnessObjects.LoginSystem;
import com.jo.healthcare.buisnessObjects.User;

public class Main {

    public static void main(String[] args) {
    	
    	
    	((MySQLConnection) MySQLConnection.getInstance()).connect();    	
    	
    	
    	
       Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user details:");
        System.out.println("Enter your role:");
        String role = scanner.nextLine();
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
        User doctor1 = new Doctor(role, firstName, lastName, userName, mobileNumber, email, password, specialization);

        //Polymorphism
        LoginSystem.registerUser(doctor1);
        LoginSystem.login(userName, password);
        System.out.println("TEST");

        
        
        
        
        
    }
}
