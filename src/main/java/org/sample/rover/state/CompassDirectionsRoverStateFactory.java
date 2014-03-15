package org.sample.rover.state;

import java.util.HashMap;
import java.util.Map;

import org.sample.rover.exception.InvalidDirective;

public class CompassDirectionsRoverStateFactory implements RoverStateFactory {
	private Map<Character, SimpleDirectedRoverState> cache;

	public CompassDirectionsRoverStateFactory() {
		cache = new HashMap<Character, SimpleDirectedRoverState>(6);
	}

	@Override
	public SimpleDirectedRoverState buildState(char direction) {
		switch (direction) {
		case 'N':
			if (!cache.containsKey(direction)) {
				cache.put(direction, new NortherlyFacingRoverState(direction));
			}
			return cache.get(direction);
		case 'E':
			if (!cache.containsKey(direction)) {
				cache.put(direction, new EasterlyFacingRoverState(direction));
			}
			return cache.get(direction);
		case 'W':
			if (!cache.containsKey(direction)) {
				cache.put(direction, new WesterlyFacingRoverState(direction));
			}
			return cache.get(direction);
		case 'S':
			if (!cache.containsKey(direction)) {
				cache.put(direction, new SoutherlyFacingRoverState(direction));
			}
			return cache.get(direction);
		default:
			throw new InvalidDirective("[" + direction
					+ "] is not a valid compass direction");
		}
	}

}
