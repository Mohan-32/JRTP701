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
@Table(name = "Jrtp_DcCase")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DcCaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Integer caseNo;
	private Integer appid;
	private Integer planid;
	

}
