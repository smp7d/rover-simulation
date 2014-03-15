package org.sample.rover.simulator;

import junit.framework.Assert;

import org.junit.Test;
import org.sample.rover.entity.Plateau;
import org.sample.rover.entity.StatelessRectangularPlateau;
import org.sample.rover.exception.InvalidPlateauDirective;

/**
 * Unit test for mars simulator.
 * 
 */
public class MarsRoverSimulatorTest {
	@Test
	public void testBuildPlateau() {
		buildPlateauHelper("5 4");
	}

	@Test(expected = InvalidPlateauDirective.class)
	public void testBuildPlateau_invalidWidth() {
		buildPlateauHelper("x 4");
	}

	@Test(expected = InvalidPlateauDirective.class)
	public void testBuildPlateau_invalidHeight() {
		buildPlateauHelper("5 y");
	}

	@Test(expected = InvalidPlateauDirective.class)
	public void testBuildPlateau_invalidFormat() {
		buildPlateauHelper("blah");
	}

	private void buildPlateauHelper(String directive) {
		MarsRoverSimulator simulator = new MarsRoverSimulator();
		Plateau plateau = simulator.buildPlateau(directive);
		Assert
				.assertTrue(
						"Plateaus on Mars are supposed to be stateless and rectangular!",
						plateau instanceof StatelessRectangularPlateau);
		Assert.assertEquals(((StatelessRectangularPlateau) plateau).getWidth(),
				5);
		Assert.assertEquals(
				((StatelessRectangularPlateau) plateau).getHeight(), 4);
	}
}
