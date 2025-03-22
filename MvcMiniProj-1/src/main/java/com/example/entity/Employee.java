package com.example.entity;

import org.hibernate.annotations.DialectOverride.SQLDelete;
import org.hibernate.annotations.DialectOverride.SQLRestriction;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity

@Table(name="employee")

@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

@org.hibernate.annotations.SQLDelete(sql="UPDATE employee SET status='inactive' WHERE eid=?")
@org.hibernate.annotations.SQLRestriction("status <> 'inactive'")
public class Employee {

	
	@Id
	
	@SequenceGenerator(name="gen1",sequenceName = "emp_id", initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer eid;
	
	
	
	private String ename;
	
	
	private String ecate;
	
	
	private Double esal;
	
	private String status="active";
}
