package org.sample.rover.command;

import org.sample.rover.entity.Rover;
import org.sample.rover.state.RoverStateContext;

public interface RoverCommand {

	public void execute(Rover rover, RoverStateContext stateContext);

}
