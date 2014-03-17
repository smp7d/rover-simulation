package org.sample.rover;

import java.util.ArrayList;
import java.util.Arrays;

import org.sample.rover.command.RoverCommandFactory;
import org.sample.rover.command.StandardRoverCommandFactory;
import org.sample.rover.simulator.MarsRoverSimulator;
import org.sample.rover.state.CompassDirectionsRoverStateFactory;
import org.sample.rover.state.RoverStateFactory;

public class RoverProcess {

	public static void main(String[] args) {
		// SET UP ROVER DIRECTIVES HERE INSTEAD OF READING IN FROM A FILE***************
		RoverDirectiveSet directiveSet = new RoverDirectiveSet();
		directiveSet.setPlateauDirective("5 5");
		directiveSet.setRoverDirectives(new ArrayList<RoverDirective>(Arrays
				.asList(new RoverDirective("1 2 N", "LMLMLMLMM"),
						new RoverDirective("3 3 E", "MMRMMRMRRM"))));
		//******************************************************************************
		
		RoverDriver driver = new RoverDriver();
		MarsRoverSimulator roverSimulator = new MarsRoverSimulator();
		RoverStateFactory roverStateFactory = new CompassDirectionsRoverStateFactory();
		roverSimulator.setRoverStateFactory(roverStateFactory);
		RoverCommandFactory roverCommandFactory = new StandardRoverCommandFactory();
		roverSimulator.setRoverCommandFactory(roverCommandFactory);
		driver.setRoverSimulator(roverSimulator);

		driver.setPlateauDirective(directiveSet.getPlateauDirective())
				.setRoverDirectives(directiveSet.getRoverDirectives());

		StatusCommunicator printer = new StatusCommunicator() {
			@Override
			public void communicateStatus(String status) {
				System.out.println(status);
			}
		};
		driver.setStatusCommunicator(printer);
		driver.runPlan();
	}
}
