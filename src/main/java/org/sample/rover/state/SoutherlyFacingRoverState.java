package org.sample.rover.state;

import org.sample.rover.entity.Rover;

public class SoutherlyFacingRoverState extends SimpleDirectedRoverState {

	public SoutherlyFacingRoverState(char direction) {
		this.readableDirection = direction;
	}

	@Override
	public void move(Rover rover, RoverStateContext context) {
		rover.move(0, -1);
	}

}
