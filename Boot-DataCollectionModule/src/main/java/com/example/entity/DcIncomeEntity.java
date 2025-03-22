package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Jrtp_DcIncome")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DcIncomeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer incomeId;
	private Integer caseNo;
	private Double EmpIncome;
	private Double PropertyIncome;
	

}
