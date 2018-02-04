package com.gk.anagram.exception;

public class ResourceException extends RuntimeException {
	private static final long serialVersionUID = -3311173925483342082L;

	public ResourceException(String message, Throwable exception) {
		super(message, exception);
	}

	public ResourceException(String message) {
		super(message);
	}
	
}
