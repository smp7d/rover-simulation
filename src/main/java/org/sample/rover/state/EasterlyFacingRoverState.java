package org.sample.rover.state;

import org.sample.rover.entity.Rover;

public class EasterlyFacingRoverState extends SimpleDirectedRoverState {

	public EasterlyFacingRoverState(char direction) {
		this.readableDirection = direction;
	}

	@Override
	public void move(Rover rover, RoverStateContext context) {
		rover.move(1, 0);
	}

}
