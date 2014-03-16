package org.sample.rover.state;

import org.sample.rover.entity.Rover;

public interface RoverState {
	void move(Rover rover, RoverStateContext context);
}
