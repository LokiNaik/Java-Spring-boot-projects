package com.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm(){
		return "hello";
	}
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model){
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();

		String result = "Hi" +" "+theName;
		model.addAttribute("message", result);
		return "hello";
	}
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
		theName = theName.toUpperCase();

		String result = "Hello" +" "+theName;
		model.addAttribute("message", result);
		return "hello";
	}

}
