package org.sample.rover.state;

import junit.framework.Assert;

import org.junit.Test;

public class CompassDirectionsRoverStateFactoryTest {

	@Test
	public void testBuildNorthState() {
		verifyBuild('N', NortherlyFacingRoverState.class);
	}

	@Test
	public void testBuildEastState() {
		verifyBuild('E', EasterlyFacingRoverState.class);
	}

	@Test
	public void testBuildSouthState() {
		verifyBuild('S', SoutherlyFacingRoverState.class);
	}

	@Test
	public void testBuildWestState() {
		verifyBuild('W', WesterlyFacingRoverState.class);
	}

	private void verifyBuild(char direction,
			Class<? extends SimpleDirectedRoverState> clazz) {
		CompassDirectionsRoverStateFactory factory = new CompassDirectionsRoverStateFactory();
		SimpleDirectedRoverState state = factory.buildState(direction);
		Assert.assertNotNull(state);
		Assert.assertTrue(clazz.isInstance(state));
		// make sure we are caching
		Assert.assertEquals(state, factory.buildState(direction));
	}
}
