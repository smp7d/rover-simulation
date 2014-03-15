package org.sample.rover.command;

import java.util.HashMap;
import java.util.Map;

import org.sample.rover.exception.InvalidDirectiveException;

public class StandardRoverCommandFactory implements RoverCommandFactory {
	// i would prefer declarative caching with a caching tool but i want to keep
	// my dependencies down for this exercise
	private Map<Character, RoverCommand> cache;

	public StandardRoverCommandFactory(){
		cache = new HashMap<Character, RoverCommand>(6);
	}
	
	@Override
	public RoverCommand buildRoverCommand(char command) {
		switch (command) {
		case 'L':
			if (!cache.containsKey(command)) {
				cache.put(command, new SpinLeftCommand());
			}
			break;
		case 'R':
			if (!cache.containsKey(command)) {
				cache.put(command, new SpinRightCommand());
			}
			break;
		case 'M':
			if (!cache.containsKey(command)) {
				cache.put(command, new MoveCommand());
			}
			break;
		case RoverCharacterCommands.PRINT:
			if (!cache.containsKey(command)) {
				cache.put(command, new StatusReportCommand());
			}
			break;
		default:
			throw new InvalidDirectiveException("[" + command
					+ "] is not a valid compass command");
		}
		return cache.get(command);
	}

}
