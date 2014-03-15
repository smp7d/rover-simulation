package org.sample.rover.simulator;

import java.io.PrintStream;

import org.sample.rover.RoverController;
import org.sample.rover.RoverDirective;
import org.sample.rover.entity.Plateau;
import org.sample.rover.entity.StatelessRectangularPlateau;
import org.sample.rover.exception.InvalidPlateauDirective;

/**
 * Simulates rover behavior as described for Mars.
 * 
 */
public class MarsRoverSimulator implements RoverSimulator {

	@Override
	public void acceptCommand(char command, RoverController controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoverController buildController(Plateau plateau,
			RoverDirective roverDirective, PrintStream printer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plateau buildPlateau(String plateauDirective) {
		// could use a factory here and abstract some logic in this class when
		// new reqs demand it
		String[] dimensions = plateauDirective.split(" ");
		if (dimensions.length != 2) {
			throw new InvalidPlateauDirective(
					"Plateau Directive should be two numbers separated by a space!");
		}

		try {
			int width = Integer.parseInt(dimensions[0]);
			int height = Integer.parseInt(dimensions[1]);

			return new StatelessRectangularPlateau(width, height);
		} catch (NumberFormatException e) {
			throw new InvalidPlateauDirective(e);
		}
	}

}
