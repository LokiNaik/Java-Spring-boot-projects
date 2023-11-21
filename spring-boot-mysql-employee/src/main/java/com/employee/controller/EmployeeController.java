package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepo repo;

	@RequestMapping("/")
	public String baseApi() {
		return "hello";
	}

	@GetMapping(path = "/employeeDetails")
	public String listOfAllEmployees(Model model) {
		List<Employee> employees = repo.findAll();
		model.addAttribute("employees", employees);
		return "home";
	}

	// Used for routing
	@RequestMapping(path = "/saveEmployeeDetails")
	public String listOfEmployees(@ModelAttribute("employees") Employee employee) {
		return "add-Employee-Form";
	}

	@PostMapping("/addemployee")
	public String addEmployee(@ModelAttribute("employees") Employee employee) {
		repo.save(employee);
		return "employee-add-confirmation";
	}

	@GetMapping("/update-employee/{id}")
	public String getById(@PathVariable(value = "id") long id, Model model) {
		Employee emp = repo.findById(id);
		model.addAttribute("employees", emp);
		return "add-Employee-Form";
	}

	@GetMapping("/delete-employee/{id}")
	public String deleteById(@PathVariable(value = "id") long id, Model model) {
		// delete employee by id
		repo.deleteById(id);

		// loading the list
		List<Employee> employees = repo.findAll();
		model.addAttribute("employees", employees);
		return "redirect:/employeeDetails";
	}

}
