package org.sample.rover.state;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.sample.rover.entity.Rover;

public class SoutherlyFacingRoverStateTest extends SimpleDirectedRoverStateTest {

	@Test
	public void testMove() {
		Rover rover = mock(Rover.class);
		SoutherlyFacingRoverState state = new SoutherlyFacingRoverState('X');
		state.move(rover, null);
		verify(rover, times(1)).move(0, -1);
	}

	@Override
	protected SimpleDirectedRoverState createStateUnderTest(
			RoverState clockwiseState, RoverState counterClockwiseState, char direction) {
		SoutherlyFacingRoverState state = new SoutherlyFacingRoverState(direction);
		state.setClockwiseState(clockwiseState);
		state.setCounterClockwiseState(counterClockwiseState);

		return state;
	}
}
