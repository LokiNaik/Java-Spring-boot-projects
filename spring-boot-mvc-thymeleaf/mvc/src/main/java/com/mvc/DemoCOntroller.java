package com.mvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoCOntroller {
	
	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("date",new Date());
		return "NewFile";
	}
	
	public String show(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		String result = "Yo! ," + theName.toUpperCase();
		model.addAttribute("message", result);
		return "helloworld";
	}

}
