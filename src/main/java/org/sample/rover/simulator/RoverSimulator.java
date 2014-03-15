package org.sample.rover.simulator;

import org.sample.rover.RoverController;
import org.sample.rover.RoverDirective;
import org.sample.rover.StatusCommunicator;
import org.sample.rover.entity.Plateau;

public interface RoverSimulator {
	Plateau buildPlateau(String plateauDirective);

	RoverController buildController(Plateau plateau,
			RoverDirective roverDirective, StatusCommunicator statusCommunicator);

	void acceptCommand(char command, RoverController controller);
}
