package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
@Table(name = " Jrtp_DcPlanEntity")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer planId;
	@Column(length = 30)
	private String planName;
	private LocalDate PstartDate;
	private LocalDate PendDate;
	private String description;
	private String active_sw;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime creationDate;
	@Column(insertable = false)
	private LocalDateTime upadationDate;
	private String createdBy;
	private String updatedBy;

}
