package com.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGHandlingClass {
 @ExceptionHandler(value = {idisNotFound.class})
  
 public ResponseEntity<Object> handlerMethod(idisNotFound idisNotFound){
	   
	 NotfoundId message = new NotfoundId(idisNotFound.getMessage());
	 
	 return new ResponseEntity<Object>(message,HttpStatus.NOT_FOUND);
 }
 
}
