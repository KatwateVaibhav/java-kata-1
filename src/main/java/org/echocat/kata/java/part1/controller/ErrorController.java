package org.echocat.kata.java.part1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ErrorController extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorController() {
		super();
	}

	public ErrorController(Throwable cause) {
		super(cause);
	}

	public ErrorController(String exception) {

		super(exception);
	}

}
