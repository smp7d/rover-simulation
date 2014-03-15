package org.sample.rover.simulator;

import junit.framework.Assert;

import org.junit.Test;
import org.sample.rover.entity.Plateau;
import org.sample.rover.entity.StatelessRectangularPlateau;

/**
 * Unit test for mars simulator.
 * 
 */
public class MarsRoverSimulatorTest {
	@Test
	public void testBuildPlateau() {
		MarsRoverSimulator simulator = new MarsRoverSimulator();
		Plateau plateau = simulator.buildPlateau("5 4");
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
