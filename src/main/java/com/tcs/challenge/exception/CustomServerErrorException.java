package com.tcs.challenge.exception;

public class CustomServerErrorException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2126665812744614133L;

	public CustomServerErrorException(String message) {
        super(message);
    }
}