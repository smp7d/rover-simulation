package org.sample.rover.exception;

public class InvalidDirective extends RuntimeException {
	private static final long serialVersionUID = -8059313337098791082L;

	public InvalidDirective(String message) {
		super(message);
	}

	public InvalidDirective(Exception cause) {
		super(cause);
	}
}
