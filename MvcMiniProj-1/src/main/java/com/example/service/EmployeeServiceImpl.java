package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repo.IEmployeeRepo;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
	private IEmployeeRepo repo;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> list = repo.findAll();
		
		return list;
	}


	@Override
	public String registerEmployee(Employee emp) {
		
		return "employee is saved with id value "+repo.save(emp).getEid();
	}


	@Override
	public Employee getEmployeeNo(int no) {
		
		Employee emp = repo.findById(no	).orElseThrow(()->new IllegalArgumentException());	
		return emp;
	}


	@Override
	public String updateEmployee(Employee emp) {
		
		
		
		return "employee is saved with id value "+ repo.save(emp).getEid();
	}


	@Override
	public String deleteEmployeeById(int id) {
		repo.deleteById(id);
		
		return "employee is deleted with id";
	}


	@Override
	public List<Employee> searchEmployeeByDynamic(Employee emp) {
		
		/*if(emp.getEname().equalsIgnoreCase("")|| emp.getEname().length()==0)
			emp.setEname(null);
		if(emp.getEcate().equalsIgnoreCase("")|| emp.getEcate().length()==0)
			emp.setEname(null);*/
		
		Example example = Example.of(emp);
		
		List<Employee > emp1 = repo.findAll(example);
		
		return emp1;
	}

}
