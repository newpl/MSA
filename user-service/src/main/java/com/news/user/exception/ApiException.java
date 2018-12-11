package com.news.user.exception;

import org.springframework.http.HttpStatus;


public class ApiException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	private String message;
	private Throwable e;

	public ApiException(HttpStatus status, String message, Throwable e) {
		this.status = status;
		this.message = message;
		this.e = e;
	}
	public ApiException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
	public ApiException(HttpStatus status, Throwable e) {
		this.status = status;
		this.e = e;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getThrowable() {
		return e;
	}
	public void setThrowable(Throwable e) {
		this.e = e;
	}
	
	
}
