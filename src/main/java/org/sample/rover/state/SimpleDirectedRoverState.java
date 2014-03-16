package org.sample.rover.state;

import org.sample.rover.entity.Rover;

public abstract class SimpleDirectedRoverState implements RoverState {
	private RoverState clockwiseState, counterClockwiseState;
	protected char readableDirection;

	@Override
	public void spinRight(Rover rover, RoverStateContext context) {
		context.setCurrentState(clockwiseState);
	}

	@Override
	public void spinLeft(Rover rover, RoverStateContext context) {
		context.setCurrentState(counterClockwiseState);
	}

	@Override
	public void reportStatus(Rover rover, RoverStateContext context) {
		rover.reportStatus(readableDirection);
	}

	public void setClockwiseState(RoverState clockwiseState) {
		this.clockwiseState = clockwiseState;
	}

	public void setCounterClockwiseState(RoverState counterClockwiseState) {
		this.counterClockwiseState = counterClockwiseState;
	}

}
