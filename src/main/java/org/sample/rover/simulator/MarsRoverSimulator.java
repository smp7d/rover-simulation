package org.sample.rover.simulator;

import org.sample.rover.RoverController;
import org.sample.rover.RoverDirective;
import org.sample.rover.StatusCommunicator;
import org.sample.rover.command.RoverCommand;
import org.sample.rover.command.RoverCommandFactory;
import org.sample.rover.entity.Plateau;
import org.sample.rover.entity.Rover;
import org.sample.rover.entity.StatelessRectangularPlateau;
import org.sample.rover.exception.InvalidDirectiveException;
import org.sample.rover.state.RoverStateContext;
import org.sample.rover.state.RoverStateFactory;
import org.sample.rover.state.SimpleDirectedRoverState;

/**
 * Simulates rover behavior as described for Mars.
 * 
 */
public class MarsRoverSimulator implements RoverSimulator {
	private RoverStateFactory roverStateFactory;
	private RoverCommandFactory roverCommandFactory;
	
	@Override
	public void acceptCommand(char command, RoverController controller) {
		RoverCommand roverCommand = roverCommandFactory.buildRoverCommand(command);
		controller.execute(roverCommand);
	}

	@Override
	public RoverController buildController(Plateau plateau,
			RoverDirective roverDirective, StatusCommunicator statusCommunicator) {
		Rover rover = new Rover();
		rover.setPlateau(plateau);
		rover.setStatusCommunicator(statusCommunicator);

		String[] directiveParts = roverDirective.getInitialPosition()
				.split(" ");
		if (directiveParts.length != 3) {
			throw new InvalidDirectiveException(
					"Initial position directive should be two numbers and one of [N,E,S,W] separated by spaces!");
		}
		
		int x = 0;
		int y = 0;
		try {
			x = Integer.parseInt(directiveParts[0]);
			y = Integer.parseInt(directiveParts[1]);
		} catch (NumberFormatException e) {
			throw new InvalidDirectiveException(e);
		}
		
		rover.setCoordinates(x,y);
		
		buildOutPossibleStates();
		RoverStateContext context = new RoverStateContext();
		char initialDirection = directiveParts[2].charAt(0);
		context.setCurrentState(roverStateFactory.buildState(initialDirection));
		
		RoverController controller = new RoverController();
		controller.setRover(rover);
		controller.setStateContext(context);
		
		return controller;
	}

	private void buildOutPossibleStates() {
		SimpleDirectedRoverState northState = roverStateFactory.buildState('N');
		SimpleDirectedRoverState eastState = roverStateFactory.buildState('E');
		SimpleDirectedRoverState southState = roverStateFactory.buildState('S');
		SimpleDirectedRoverState westState = roverStateFactory.buildState('W');
		
		northState.setClockwiseState(eastState);
		northState.setCounterClockwiseState(westState);
		
		eastState.setClockwiseState(southState);
		eastState.setCounterClockwiseState(northState);
		
		southState.setClockwiseState(westState);
		southState.setCounterClockwiseState(eastState);
		
		westState.setClockwiseState(northState);
		westState.setCounterClockwiseState(southState);
	}

	@Override
	public Plateau buildPlateau(String plateauDirective) {
		// could use a factory here and abstract some logic in this class when
		// new reqs demand it
		String[] dimensions = plateauDirective.split(" ");
		if (dimensions.length != 2) {
			throw new InvalidDirectiveException(
					"Plateau Directive should be two numbers separated by a space!");
		}

		try {
			int width = Integer.parseInt(dimensions[0]);
			int height = Integer.parseInt(dimensions[1]);

			return new StatelessRectangularPlateau(width, height);
		} catch (NumberFormatException e) {
			throw new InvalidDirectiveException(e);
		}
	}

	public void setRoverStateFactory(RoverStateFactory roverStateFactory) {
		this.roverStateFactory = roverStateFactory;
	}

	public void setRoverCommandFactory(RoverCommandFactory roverCommandFactory) {
		this.roverCommandFactory = roverCommandFactory;
	}

}
