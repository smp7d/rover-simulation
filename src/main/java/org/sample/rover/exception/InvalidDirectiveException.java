package org.sample.rover.exception;

public class InvalidDirectiveException extends RuntimeException {
	private static final long serialVersionUID = -8059313337098791082L;

	public InvalidDirectiveException(String message) {
		super(message);
	}

	public InvalidDirectiveException(Exception cause) {
		super(cause);
	}
}
