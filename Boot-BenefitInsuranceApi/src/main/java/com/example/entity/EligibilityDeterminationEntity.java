package com.example.entity;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Jrtp_Eligibility_Determination")
@Data
@NoArgsConstructor

@AllArgsConstructor
public class EligibilityDeterminationEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer EDtrace_Id;
	private Integer caseNo;
	private String holderName;
	private Long holderSSn;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benfamt;
	private String denialReas;
	private Long accNumber;
	private String bankName;
	
}
