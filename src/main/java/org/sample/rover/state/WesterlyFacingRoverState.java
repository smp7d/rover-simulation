package org.sample.rover.state;

import org.sample.rover.entity.Rover;

public class WesterlyFacingRoverState extends SimpleDirectedRoverState {

	public WesterlyFacingRoverState(char direction) {
		this.readableDirection = direction;
	}

	@Override
	public void move(Rover rover, RoverStateContext context) {
		// TODO Auto-generated method stub
		
	}

}
