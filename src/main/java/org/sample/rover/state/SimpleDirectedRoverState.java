package org.sample.rover.state;


public abstract class SimpleDirectedRoverState implements RoverState {
	private RoverState clockwiseState, counterClockwiseState;
	protected char readableDirection;

	
	public void setClockwiseState(RoverState clockwiseState) {
		this.clockwiseState = clockwiseState;
	}

	public void setCounterClockwiseState(RoverState counterClockwiseState) {
		this.counterClockwiseState = counterClockwiseState;
	}

}
