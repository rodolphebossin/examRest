package com.humanbooster.rodolphe_bossin_rest.model;

public class ValidationError {
	
	private String error;
	private String input;
	
	
	public ValidationError(String input,String error) {
		this.input = input;
		this.error = error;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getInput() {
		return input;
	}


	public void setInput(String input) {
		this.input = input;
	}
	
	

}
