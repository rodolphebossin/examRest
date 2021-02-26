package com.humanbooster.rodolphe_bossin_rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.humanbooster.rodolphe_bossin_rest.model.ValidationError;


@ControllerAdvice
@ResponseBody
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		List<ValidationError> errors = new ArrayList<>();
		BindingResult br = ex.getBindingResult();
		List<FieldError> fieldErrors = br.getFieldErrors();
		
		for(FieldError e : fieldErrors) {
			errors.add(new ValidationError(e.getField(), e.getDefaultMessage()));
		}
		
		return this.handleExceptionInternal(ex,(Object) errors, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		String path = ((MismatchedInputException)ex.getCause()).getPath().toString();
		ValidationError ev = new ValidationError(path, ex.getCause().getMessage());
		return new ResponseEntity<>(ev, HttpStatus.BAD_REQUEST);
	}

}
