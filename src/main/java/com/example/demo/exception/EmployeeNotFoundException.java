package com.example.demo.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends EntityNotFoundException {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String exception) {
	    super(exception);
	  }

	}