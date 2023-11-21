package com.sql.mappings.sql.mappings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sql.mappings.sql.mappings.EmployeeRepo.EmployeeDetailsRepo;
import com.sql.mappings.sql.mappings.EmployeeRepo.EmployeeRepo;
import com.sql.mappings.sql.mappings.entity.Employee;
import com.sql.mappings.sql.mappings.entity.EmployeeDetails;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private EmployeeDetailsRepo detailsRepo;
	
	@PostMapping("/saveemployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		EmployeeDetails details = detailsRepo.save(employee.getDetails());
		return repo.save(employee);
	}
	
//	@PostMapping("/empdetails")
//	public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employee) {
//		return 
//	}
	
	@GetMapping("/")
	public List<Employee> getEmployee() {
		return repo.findAll();
	}
	
	

}
