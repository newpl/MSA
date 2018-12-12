package com.news.user.exception;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApiErrorMessage {
	private int status;
	private String error;
	private String message;
}
