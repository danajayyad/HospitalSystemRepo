package com.jo.healthcare.services;

import com.jo.healthcare.buisnessObjects.MedicalRecord;

public interface MedicalRecordServicesInterface {

		public void addMedicalHistory(MedicalRecord medicalRecord ,String history);
		
		public void addAllergy(MedicalRecord medicalRecord,String allergy);
		
	    public void addMedication(MedicalRecord medicalRecord,String medication);
	    
	    public void addTestResult(MedicalRecord medicalRecord ,String testName, String result);
	    
	    public void addSurgery(MedicalRecord medicalRecord, String surgery);
	    
	    public void removeMedication(MedicalRecord medicalRecord, String medication);
	   
	    public void removeAllergy(MedicalRecord medicalRecord, String allergy);
	    
	    public void removeTestResult(MedicalRecord medicalRecord, String testName);
	    
	    public void removeSurgery(MedicalRecord medicalRecord, String surgery);
	    
	    public void viewMedicalRecord(MedicalRecord medicalRecord);
	    
	
	
}
