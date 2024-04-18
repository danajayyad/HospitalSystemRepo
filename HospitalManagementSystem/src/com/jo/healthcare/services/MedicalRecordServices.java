package com.jo.healthcare.services;

import com.jo.healthcare.buisnessObjects.MedicalRecord;

public class MedicalRecordServices implements MedicalRecordServicesInterface {

	 public void addMedicalHistory(MedicalRecord medicalRecord ,String history)
	    {
		 medicalRecord.getMedicalHistory().add(history);
	    }
	 

	    public void addAllergy(MedicalRecord medicalRecord,String allergy)
	    {
	    	medicalRecord.getAllergies().add(allergy);
	    }

	    
	    public void addMedication(MedicalRecord medicalRecord,String medication)
	    {
	    	medicalRecord.getMedications().add(medication);
	    }

	    
	    public void addTestResult(MedicalRecord medicalRecord ,String testName, String result)
	    {
	    	medicalRecord.getTestResults().add(testName + ": " + result);
	    }

	    
	    public void addSurgery(MedicalRecord medicalRecord, String surgery)
	    {
	    	medicalRecord.getSurgeries().add(surgery);
	    }

	    
	    public void removeMedication(MedicalRecord medicalRecord, String medication)
	    {
	    	medicalRecord.getMedications().remove(medication);
	    }

	    
	    public void removeAllergy(MedicalRecord medicalRecord, String allergy)
	    {
	    	medicalRecord.getAllergies().remove(allergy);
	    }

	    
	    public void removeTestResult(MedicalRecord medicalRecord, String testName)
	    {
	    	medicalRecord.getTestResults().removeIf(result -> result.startsWith(testName + ":"));  // ex. removeTestResult(Blood Test:) this removes all BLood Tests from the list
	    }

	    
	    public void removeSurgery(MedicalRecord medicalRecord, String surgery)
	    {
	    	medicalRecord.getSurgeries().remove(surgery);
	    }

	    
	    public void viewMedicalRecord(MedicalRecord medicalRecord)
	    {
	    	System.out.println("Medical History:");
	        for (String history : medicalRecord.getMedicalHistory())
	        {
	        	System.out.println("- " + history);
	        }
	        System.out.println("Allergies:");
	        for (String allergy : medicalRecord.getAllergies()) 
	        {
	        	System.out.println("- " + allergy);
	        }
	        System.out.println("Current Medications:");
	        for (String medication : medicalRecord.getMedications())
	        {
	        	System.out.println("- " + medication);
	        }
	        System.out.println("Test Results:");
	        for (String result : medicalRecord.getTestResults())
	        {
	        	System.out.println("- " + result);
	        }
	        System.out.println("Surgeries:");
	        for (String surgery : medicalRecord.getSurgeries()) 
	        {
	        	System.out.println("- " + surgery);
	        }
	    }
}
