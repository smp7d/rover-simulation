package org.sample.rover;

public class RoverDirective {
	private String initialPosition;
	private String commands;

	public RoverDirective(final String initialPosition, final String commands) {
		this.initialPosition = initialPosition;
		this.commands = commands;
	}

	public String getInitialPosition() {
		return initialPosition;
	}

	public String getCommands() {
		return commands;
	}
}