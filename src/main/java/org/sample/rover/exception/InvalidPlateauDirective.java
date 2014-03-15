package org.sample.rover.exception;

public class InvalidPlateauDirective extends RuntimeException {
	private static final long serialVersionUID = -8059313337098791082L;

	public InvalidPlateauDirective(String message) {
		super(message);
	}

	public InvalidPlateauDirective(Exception cause) {
		super(cause);
	}
}
