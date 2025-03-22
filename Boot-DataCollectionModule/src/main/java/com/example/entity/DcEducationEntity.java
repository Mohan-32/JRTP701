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
@Table(name ="Jrtp_DcEducation")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class DcEducationEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer eduid;
	private Integer caseNo;
	private String HighestQlfy;
	private Integer passoutYear;

}
