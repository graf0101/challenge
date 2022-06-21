package com.tcs.challenge.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@ToString
public class ServerError extends RuntimeException {
	/**
	 * 
	 */

	private static final long serialVersionUID = 6937444535108959182L;
	@Getter
	private HttpStatus status;
	@Getter
	private String body;

	public ServerError(HttpStatus status, String body) {
		this.status = status;
		this.body = body;
	}
}