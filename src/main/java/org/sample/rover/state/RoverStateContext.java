package org.sample.rover.state;

import org.sample.rover.entity.Rover;

public class RoverStateContext {
	private RoverState currentState;

	public void move(Rover rover) {
		currentState.move(rover, this);
	}

	public void spinRight(Rover rover) {
		currentState.spinRight(rover, this);
	}

	public void spinLeft(Rover rover) {
		currentState.spinLeft(rover, this);
	}

	public void reportStatus(Rover rover) {
		currentState.reportStatus(rover, this);
	}

	public void setCurrentState(RoverState currentState) {
		this.currentState = currentState;
	}
}
