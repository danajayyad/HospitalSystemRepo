package com.jo.healthcare.buisnessObjects;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private List<String> medicalHistory;
    private List<String> allergies;
    private List<String> medications;
    private List<String> testResults;
    private List<String> surgeries;
  
    public List<String> getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(List<String> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	public List<String> getTestResults() {
		return testResults;
	}

	public void setTestResults(List<String> testResults) {
		this.testResults = testResults;
	}

	public List<String> getSurgeries() {
		return surgeries;
	}

	public void setSurgeries(List<String> surgeries) {
		this.surgeries = surgeries;
	}

    public MedicalRecord() {
        this.medicalHistory = new ArrayList<>(); //ex. Catheterization performed in jun 2020
        this.allergies = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.testResults = new ArrayList<>();
        this.surgeries = new ArrayList<>();
    }

   

}
