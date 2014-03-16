package org.sample.rover.command;

import org.sample.rover.entity.Rover;
import org.sample.rover.state.RoverStateContext;

public class MoveCommand implements RoverCommand {

	@Override
	public void execute(Rover rover, RoverStateContext stateContext) {
		stateContext.move(rover);
	}

}
