package com.jo.healthcare.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jo.healthcare.buisnessObjects.LoginSystem;


public class MedicalRecordServices implements MedicalRecordServicesInterface {
	
	
	private Connection conn = LoginSystem.getConn();


    public void addMedicalHistory(String user_id, String history){
        String sql = "INSERT INTO MedicalHistory (user_id, history) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, history);
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void addMedication(String user_id, String medication)  {
        String sql = "INSERT INTO Medication (user_id, medication) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, medication);
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void addTestResult(String user_id, String testName, String result) throws SQLException {
        String sql = "INSERT INTO Test (user_id, test_name, result) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, testName);
            stmt.setString(3, result);
            stmt.executeUpdate();
        }
    }

    public void addSurgery(String user_id, String surgery) throws SQLException {
        String sql = "INSERT INTO Surgery (user_id, surgery) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, surgery);
            stmt.executeUpdate();
        }
    }

    public void addAllergy(String user_id, String allergy) throws SQLException {
        String sql = "INSERT INTO Allergy (user_id, allergy) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, allergy);
            stmt.executeUpdate();
        }
    }

    public void removeMedication(String user_id, String medication_id) throws SQLException {
        String sql = "DELETE FROM Medication WHERE user_id = ? AND medication_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, medication_id);
            stmt.executeUpdate();
        }
    }

    public void removeAllergy(String user_id, String allergy_id) throws SQLException {
        String sql = "DELETE FROM Allergy WHERE user_id = ? AND allergy_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, allergy_id);
            stmt.executeUpdate();
        }
    }

    public void removeTestResult(String user_id, String test_id) throws SQLException {
        String sql = "DELETE FROM Test WHERE user_id = ? AND test_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, test_id);
            stmt.executeUpdate();
        }
    }

    public void removeSurgery(String user_id, String surgery_id) throws SQLException {
        String sql = "DELETE FROM Surgery WHERE user_id = ? AND surgery_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user_id);
            stmt.setString(2, surgery_id);
            stmt.executeUpdate();
        }
    }

	   
	    
	    
	    
	    public void viewMedicalRecord(String user_id) throws SQLException{
	        System.out.println("Medical History:");
	        String medicalHistoryQuery = "SELECT history FROM MedicalHistory WHERE user_id = ?";
	        PreparedStatement historyStmt = conn.prepareStatement(medicalHistoryQuery);
	            historyStmt.setString(1, user_id);
	            ResultSet historyResultSet = historyStmt.executeQuery();
	            while (historyResultSet.next()) {
	                System.out.println("- " + historyResultSet.getString("history"));
	            }
	        

	        System.out.println("Allergies:");
	        String allergyQuery = "SELECT allergy FROM Allergy WHERE user_id = ?";
	        PreparedStatement allergyStmt = conn.prepareStatement(allergyQuery);
	            allergyStmt.setString(1, user_id);
	            ResultSet allergyResultSet = allergyStmt.executeQuery();
	            while (allergyResultSet.next()) {
	                System.out.println("- " + allergyResultSet.getString("allergy"));
	            }
	        

	        System.out.println("Current Medications:");
	        String medicationQuery = "SELECT medication FROM Medication WHERE user_id = ?";
	        PreparedStatement medicationStmt = conn.prepareStatement(medicationQuery);
	            medicationStmt.setString(1, user_id);
	            ResultSet medicationResultSet = medicationStmt.executeQuery();
	            while (medicationResultSet.next()) {
	                System.out.println("- " + medicationResultSet.getString("medication"));
	            }
	        

	        System.out.println("Test Results:");
	        String testQuery = "SELECT test_name, result FROM Test WHERE user_id = ?";
	        PreparedStatement testStmt = conn.prepareStatement(testQuery);
	            testStmt.setString(1, user_id);
	            ResultSet testResultSet = testStmt.executeQuery();
	            while (testResultSet.next()) {
	                System.out.println("- " + testResultSet.getString("test_name") + ": " + testResultSet.getString("result"));
	            }
	        

	        System.out.println("Surgeries:");
	        String surgeryQuery = "SELECT surgery FROM Surgery WHERE user_id = ?";
	        PreparedStatement surgeryStmt = conn.prepareStatement(surgeryQuery);
	            surgeryStmt.setString(1, user_id);
	            ResultSet surgeryResultSet = surgeryStmt.executeQuery();
	            while (surgeryResultSet.next()) {
	                System.out.println("- " + surgeryResultSet.getString("surgery"));
	            }
	        }
}