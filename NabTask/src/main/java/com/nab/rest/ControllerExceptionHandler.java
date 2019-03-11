package com.nab.rest;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nab.vo.ErrorMessage;



@ControllerAdvice
public class ControllerExceptionHandler {


	@ResponseBody
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ErrorMessage handleException(ValidationException e) {
		return new ErrorMessage(400 , e.getMessage());
	}
	
	@ResponseBody
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ErrorMessage handleException( MethodArgumentNotValidException e) {
		return new ErrorMessage(400 , e.getMessage());
	}
}
