package org.sample.rover.state;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.sample.rover.entity.Rover;

public class WesterlyFacingRoverStateTest extends SimpleDirectedRoverStateTest {

	@Test
	public void testMove() {
		Rover rover = mock(Rover.class);
		WesterlyFacingRoverState state = new WesterlyFacingRoverState('X');
		state.move(rover, null);
		verify(rover, times(1)).move(-1, 0);
	}

	@Override
	protected SimpleDirectedRoverState createStateUnderTest(
			RoverState clockwiseState, RoverState counterClockwiseState,
			char direction) {
		WesterlyFacingRoverState state = new WesterlyFacingRoverState(direction);
		state.setClockwiseState(clockwiseState);
		state.setCounterClockwiseState(counterClockwiseState);

		return state;
	}
}
