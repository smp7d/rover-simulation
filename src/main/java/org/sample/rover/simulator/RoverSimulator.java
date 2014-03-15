package org.sample.rover.simulator;

import java.io.PrintStream;

import org.sample.rover.RoverController;
import org.sample.rover.RoverDirective;
import org.sample.rover.entity.Plateau;

public interface RoverSimulator {
	Plateau buildPlateau(String plateauDirective);

	RoverController buildController(Plateau plateau,
			RoverDirective roverDirective, PrintStream printer);

	void acceptCommand(char command, RoverController controller);
}
