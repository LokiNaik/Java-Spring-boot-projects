package com.mycode.springbootrestcrudstudent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@ExceptionHandler
	public ResponseEntity<StudentExceptionResponse> handleException(StudentNotFoundException excpetion){
		StudentExceptionResponse error = new StudentExceptionResponse();
		error.setMessage("student not found");
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setTimeStamp(System.currentTimeMillis());
		return null;
		
	}
	
	StudentExceptionResponse res = new StudentExceptionResponse();
	
	public void show() {
		 res.setMessage("Hello");	
	}
	
	public String hello() {
		
		return res.getMessage();
	}
		

}
