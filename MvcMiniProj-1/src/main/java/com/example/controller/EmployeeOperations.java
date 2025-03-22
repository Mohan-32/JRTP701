package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Employee;
import com.example.service.IEmployeeService;

@Controller
public class EmployeeOperations {
	
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String showWelcome() {
		
		return "welcome";
	} 

	@GetMapping("/report")
	public String showEmployeeReport(Map<String,Object> map) {
		
		List<Employee> list = service.getAllEmployees();
		map.put("list", list);
		
		return "show_employee_report";
	}
	
	
	
	@GetMapping("/add")
	public String showEmployeeReport(@ModelAttribute("emp") Employee emp) {
		
		
		
		return "register_Employee";
	}
	
	
	@PostMapping("/add")
	public String showEmployeeForPost(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
		
		 String msg = service.registerEmployee(emp);
		// List<Employee> list=service.getAllEmployees();
		 attrs.addFlashAttribute("resultmsg",msg);
		 
		 
		 
		
		return "redirect:report";
	}
	
	
	@GetMapping("/edit")
	public String showEditFormPage(@ModelAttribute("emp") Employee emp , @RequestParam("no") int no) {
		
		Employee emp1 = service.getEmployeeNo(no);
		BeanUtils.copyProperties(emp1, emp);
		
		return "update_employee";
	}
	

	@PostMapping("/edit")
	public String showEmployeesForPost(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
		
		 String msg = service.updateEmployee(emp);
		// List<Employee> list=service.getAllEmployees();
		 attrs.addFlashAttribute("resultmsg",msg);
		 
		 
		 
		
		return "redirect:report";
	}
	@GetMapping("/delete")
	public String showEditFormPage(RedirectAttributes attrs , @RequestParam("no") int no) {
		
		String msg = service.deleteEmployeeById(no);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
		
	}
	
	@GetMapping("/search")
	public String showEditFormPage(@ModelAttribute("emp") Employee emp ) {
		
		//Employee emp1 = service.getEmployeeNo(no);
		
		return "show_employee_report1";
	}
	
	
	
	
	@PostMapping("/search")
	public String showEmployeesByDynamicSearch(@ModelAttribute("emp") Employee emp, Map<String,Object> map) {
		
		 
		 List<Employee> list = service.searchEmployeeByDynamic(emp);
		// List<Employee> list=service.getAllEmployees();
		 map.put("list",list);
		 
		 
		 
		
		return "show_employee_report";
	}
	

	
	}
