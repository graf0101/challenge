package com.tcs.challenge.exception;

public class CustomBadRequestException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6503774118878218728L;

	public CustomBadRequestException(String message) {
		super(message);
	}
}