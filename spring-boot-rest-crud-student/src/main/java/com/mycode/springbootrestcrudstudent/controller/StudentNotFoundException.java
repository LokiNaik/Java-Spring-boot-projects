package com.mycode.springbootrestcrudstudent.controller;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException(String message) {
		super(message);
	}
}
