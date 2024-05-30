package com.jo.healthcare.services;

import java.sql.SQLException;


public interface MedicalRecordServicesInterface {

	public void addMedicalHistory(String user_id, String history) throws SQLException;
	public void addMedication(String user_id, String medication) throws SQLException;
	public void addTestResult(String user_id, String testName, String result) throws SQLException;
	public void addSurgery(String user_id, String surgery) throws SQLException;
	public void addAllergy(String user_id, String allergy) throws SQLException ;
	public void viewMedicalRecord(String user_id) throws SQLException;	
	
}
