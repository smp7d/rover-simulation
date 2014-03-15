package org.sample.rover.state;

public interface RoverStateFactory {

	SimpleDirectedRoverState buildState(char c);

}
