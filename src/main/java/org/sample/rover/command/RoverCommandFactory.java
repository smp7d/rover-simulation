package org.sample.rover.command;

public interface RoverCommandFactory {
	RoverCommand buildRoverCommand(char c);
}
