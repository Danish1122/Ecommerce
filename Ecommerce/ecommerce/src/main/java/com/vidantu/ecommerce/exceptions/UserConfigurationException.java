package com.vidantu.ecommerce.exceptions;

public class UserConfigurationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private UserConfigurationException(String message) {
		super(message);
	}
	
	private UserConfigurationException(String message,Throwable th) {
		super(message,th);
	}

	
}
