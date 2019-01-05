package com.vidantu.ecommerce.exceptions;

public class DatabaseException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private DatabaseException(String message) {
		super(message);
	}

	private DatabaseException(Throwable th, String message) {
		super(message, th);
	} 

}
