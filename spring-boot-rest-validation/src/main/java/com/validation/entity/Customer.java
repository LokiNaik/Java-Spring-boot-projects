package com.validation.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.validation.customAnnotation.CustomAnnotation;


public class Customer {
	
	@NotNull(message ="required")
	@Min(value = 0, message = "must be zero or greater")
	@Max(value = 10, message = "must not be greater that 10")
	private Integer pass;
	
	private String firstName;

	@NotNull(message = "required filed")
	@Size(min = 1, message = "is required")
	private String lastName = "";
	
	@Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
            message = "username must be of 6 to 12 length with no special characters")
	private String username;
	
	
	@NotNull
	@CustomAnnotation(value = "TOPS", message = "must start with TOPS")
	private String courseCode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
	
}
