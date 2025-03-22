package com.example.bindingd;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ChildInputs {
	private Integer childId;
	private Integer caseNo;
	private LocalDate dob;
	private Integer ssn;


}
