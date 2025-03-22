package com.example.bindingd;

import java.util.List;

import lombok.Data;

@Data
public class DcSummaryReport {
	
	
	private String planName;
	private EducationInputs eduDetails;
	private List<ChildInputs> childrenDetails;
	private IncomeInputs incomeDetails;
	private CitizenAppRegistrationInputs citizenInputs;
	 
	
	
	

}
