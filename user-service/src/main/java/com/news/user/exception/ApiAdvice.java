package com.news.user.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {ApiException.class})
	@ResponseBody
	protected ResponseEntity<Object> handleApiException(ApiException restCtrlException, WebRequest request) {
		ApiErrorMessage apiErrorMessage = new ApiErrorMessage();
		int status = restCtrlException.getStatus().value();
		String error = restCtrlException.getStatus().getReasonPhrase();
		String message = restCtrlException.getMessage();
		Throwable e = restCtrlException.getThrowable();
		apiErrorMessage.setStatus(status);
		apiErrorMessage.setError(error);
		
		if (e != null && e.getMessage() != null) {
			if (message != null) {
				message += " - " + restCtrlException.getThrowable().getMessage();
			} else {
				message = restCtrlException.getThrowable().getMessage();
			}
		} else {
			if (message == null) {
				message = "N/A";
			}
		}
		
		apiErrorMessage.setMessage(message);
		return handleExceptionInternal(restCtrlException, apiErrorMessage, new HttpHeaders(), restCtrlException.getStatus(), request);
	}
	
	@ExceptionHandler(value= {RuntimeException.class})
	@ResponseBody
	protected ResponseEntity<Object> handleThrowable(RuntimeException e, WebRequest request) {
		HttpStatus defaultHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		ApiErrorMessage apiErrorMessage = new ApiErrorMessage();
		
		int status = defaultHttpStatus.value();
		String error = defaultHttpStatus.getReasonPhrase();
		String message = e.getMessage();
		
		apiErrorMessage.setStatus(status);
		apiErrorMessage.setMessage(message);
		apiErrorMessage.setError(error);
		
		return handleExceptionInternal(e, apiErrorMessage, new HttpHeaders(), defaultHttpStatus, request);
	}
		
}
