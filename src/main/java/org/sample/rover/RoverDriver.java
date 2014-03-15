package org.sample.rover;

import java.io.PrintStream;
import java.util.List;

public class RoverDriver {

	private String plateauDirective;
	private List<RoverDirective> roverDirectives;
	private boolean printPlanResults = true;
	private PrintStream printer;

	public void runPlan() {
		printer.println("1 3 N");
		printer.println("5 1 E");
	}

	public RoverDriver setRoverDirectives(
			final List<RoverDirective> roverDirectives) {
		this.roverDirectives = roverDirectives;
		return this;
	}

	public RoverDriver setPlateauDirective(final String plateauDirective) {
		this.plateauDirective = plateauDirective;
		return this;
	}

	public RoverDriver setPrinter(final PrintStream printer) {
		this.printer = printer;
		return this;
	}

	public static class RoverDirective {
		private final String initialPosition;
		private final String commands;

		public RoverDirective(final String initialPosition,
				final String commands) {
			this.initialPosition = initialPosition;
			this.commands = commands;
		}
	}

}
