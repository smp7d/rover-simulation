package org.sample.rover.exception;

public class InvalidCoordinatesException extends RuntimeException {
	private static final long serialVersionUID = -189928897703370174L;

	public InvalidCoordinatesException(String message) {
		super(message);
	}
}
