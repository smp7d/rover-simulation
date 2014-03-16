package org.sample.rover.state;

import org.junit.Test;
import org.sample.rover.entity.Rover;
import static org.mockito.Mockito.*;

public class EasterlyFacingRoverStateTest extends SimpleDirectedRoverStateTest {

	@Test
	public void testMove() {
		Rover rover = mock(Rover.class);
		EasterlyFacingRoverState state = new EasterlyFacingRoverState('X');
		state.move(rover, null);
		verify(rover, times(1)).move(1, 0);
	}

	@Override
	protected SimpleDirectedRoverState createStateUnderTest(
			RoverState clockwiseState, RoverState counterClockwiseState, char direction) {
		EasterlyFacingRoverState state = new EasterlyFacingRoverState(direction);
		state.setClockwiseState(clockwiseState);
		state.setCounterClockwiseState(counterClockwiseState);

		return state;
	}
}
