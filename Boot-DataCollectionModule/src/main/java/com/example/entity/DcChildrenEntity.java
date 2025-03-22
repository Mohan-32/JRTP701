package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Jrtp_DcChildren")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DcChildrenEntity {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer childId;
	private Integer caseNo;
	private LocalDate dob;
	private Integer ssn;

}
