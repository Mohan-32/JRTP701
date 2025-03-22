package com.example.binding;

import java.time.LocalDate;

import lombok.Data;
@Data
public class EligibilityDeterminationBinding {
	
	private Integer caseNo;
	private String holderName;
	private Long holderSSn;
	//private String planName;
	//private String planStatus;
	//private LocalDate planStartDate;
	//private LocalDate planEndDate;
	private Double benfamt;
	//private String denialReas;
	private Long accNumber;
	private String bankName;

}
