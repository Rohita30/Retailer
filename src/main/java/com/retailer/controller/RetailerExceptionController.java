package com.retailer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.retailer.exception.RetailerNotFoundException;

@ControllerAdvice
public class RetailerExceptionController { 
	
	@ExceptionHandler(value = RetailerNotFoundException.class)
	   public ResponseEntity<Object> exception(RetailerNotFoundException exception) {
		   
	      return new ResponseEntity<>("Retailer is not found", HttpStatus.NOT_FOUND);
	      
	   }

}
