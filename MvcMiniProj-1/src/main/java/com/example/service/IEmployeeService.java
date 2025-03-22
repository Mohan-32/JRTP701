package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface IEmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public String registerEmployee(Employee emp);
    
	
	public Employee getEmployeeNo(int no);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int id);
	
	public List<Employee> searchEmployeeByDynamic(Employee emp);
}