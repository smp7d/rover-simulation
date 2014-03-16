package org.sample.rover.state;

import org.sample.rover.entity.Rover;

public class RoverStateContext {
	private RoverState currentState;

	public void move(Rover rover) {
		currentState.move(rover, this);
	}

	public void spinRight(Rover rover) {
		// TODO Auto-generated method stub

	}

	public void setCurrentState(RoverState currentState) {
		this.currentState = currentState;
	}

	public void spinLeft(Rover rover) {
		// TODO Auto-generated method stub

	}

	public void reportStatus(Rover rover) {
		// TODO Auto-generated method stub

	}
}
