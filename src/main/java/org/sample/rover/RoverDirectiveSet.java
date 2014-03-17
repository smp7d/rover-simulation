package org.sample.rover;

import java.util.List;

public class RoverDirectiveSet {
	private String plateauDirective;
	private List<RoverDirective> roverDirectives;

	public String getPlateauDirective() {
		return plateauDirective;
	}

	public List<RoverDirective> getRoverDirectives() {
		return roverDirectives;
	}

	public void setPlateauDirective(String plateauDirective) {
		this.plateauDirective = plateauDirective;
	}

	public void setRoverDirectives(List<RoverDirective> roverDirectives) {
		this.roverDirectives = roverDirectives;
	}
}
