package com.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mvc.model.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${favLanguage}")
	private List<String> favLanguage;
	
	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("country", countries);
		model.addAttribute("favLanguage", favLanguage);
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student student) {
//		System.out.println("student: "+student.getFirstName()+ " "+student.getLastName());
		return "student-confirmation";
	}
	
}

