package org.sample.rover.state;

import org.junit.Test;
import org.sample.rover.entity.Rover;
import static org.mockito.Mockito.*;

/**
 * Test template to abstract commonalities.
 * 
 */
public abstract class SimpleDirectedRoverStateTest {

	@Test
	public void testSpinRight() {
		RoverState clockwiseState = createSampleRoverState();
		SimpleDirectedRoverState state = createStateUnderTest(clockwiseState,
				null);
		Rover rover = null;
		RoverStateContext context = mock(RoverStateContext.class);
		state.spinRight(rover, context);
		verify(context, times(1)).setCurrentState(clockwiseState);
	}

	private RoverState createSampleRoverState() {
		return new RoverState() {

			@Override
			public void spinRight(Rover rover, RoverStateContext context) {
				// TODO Auto-generated method stub

			}

			@Override
			public void move(Rover rover, RoverStateContext context) {
				// TODO Auto-generated method stub

			}
		};
	}

	protected abstract SimpleDirectedRoverState createStateUnderTest(
			RoverState clockwiseState, RoverState counterClockwiseState);
}
