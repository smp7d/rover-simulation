package org.sample.rover;

import java.io.PrintStream;
import java.util.List;

import org.sample.rover.command.RoverCharacterCommands;
import org.sample.rover.entity.Plateau;
import org.sample.rover.simulator.RoverSimulator;

public class RoverDriver {

	private String plateauDirective;
	private List<RoverDirective> roverDirectives;
	private boolean printPlanResults = true;
	private PrintStream printer;
	private RoverSimulator roverSimulator;

	public void runPlan() {
		Plateau plateau = roverSimulator.buildPlateau(plateauDirective);
		for (RoverDirective directive : roverDirectives) {
			RoverController controller = roverSimulator.buildController(
					plateau, directive, printer);
			for (int i = 0; i < directive.getCommands().length(); i++) {
				roverSimulator.acceptCommand(directive.getCommands().charAt(i),
						controller);
			}
			if (printPlanResults) {
				roverSimulator.acceptCommand(RoverCharacterCommands.PRINT,
						controller);
			}
		}

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

	public void setRoverSimulator(RoverSimulator roverSimulator) {
		this.roverSimulator = roverSimulator;
	}

}
