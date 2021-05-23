package com.mt.film.exception;

public class DirectorNameNotFound extends Exception{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public DirectorNameNotFound(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	
		
}
