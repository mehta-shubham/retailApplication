package com.retail.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import oracle.net.ano.SupervisorService;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
}
