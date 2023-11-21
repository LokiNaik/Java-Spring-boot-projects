package com.mycode.springbootrestcrudstudent.controller;

import org.springframework.http.HttpStatus;

public class StudentExceptionResponse {

	private HttpStatus status;
	private String message;
	private long timeStamp;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus notFound) {
		this.status = notFound;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
