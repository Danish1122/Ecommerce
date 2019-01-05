package com.vidantu.ecommerce.exceptions;

public class UserConfigurationClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserConfigurationClientException(String message) {
		super(message);
	}

	private UserConfigurationClientException(String message, Throwable th) {
		super(message, th);
	}

}
