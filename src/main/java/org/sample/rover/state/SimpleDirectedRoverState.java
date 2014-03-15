package org.sample.rover.state;

public class SimpleDirectedRoverState implements RoverState {
	private RoverState clockwiseState, counterClockwiseState;

	public void setClockwiseState(RoverState clockwiseState) {
		this.clockwiseState = clockwiseState;
	}

	public void setCounterClockwiseState(RoverState counterClockwiseState) {
		this.counterClockwiseState = counterClockwiseState;
	}

}
