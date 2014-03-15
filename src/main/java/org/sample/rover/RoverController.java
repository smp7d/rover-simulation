package org.sample.rover;

import org.sample.rover.entity.Rover;
import org.sample.rover.state.RoverStateContext;

public class RoverController {
	private Rover rover;
	private RoverStateContext stateContext;

	public void setRover(Rover rover) {
		this.rover = rover;
	}

	public void setStateContext(RoverStateContext stateContext) {
		this.stateContext = stateContext;
	}

	public Rover getRover() {
		return rover;
	}

	public RoverStateContext getStateContext() {
		return stateContext;
	}
}
