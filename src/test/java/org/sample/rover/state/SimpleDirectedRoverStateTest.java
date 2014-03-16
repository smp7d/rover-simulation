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

	@Test
	public void testSpinLeft() {
		RoverState counterClockwiseState = createSampleRoverState();
		SimpleDirectedRoverState state = createStateUnderTest(null,
				counterClockwiseState);
		Rover rover = null;
		RoverStateContext context = mock(RoverStateContext.class);
		state.spinLeft(rover, context);
		verify(context, times(1)).setCurrentState(counterClockwiseState);
	}

	private RoverState createSampleRoverState() {
		return new RoverState() {

			@Override
			public void spinRight(Rover rover, RoverStateContext context) {
				
			}

			@Override
			public void move(Rover rover, RoverStateContext context) {
				
			}

			@Override
			public void spinLeft(Rover rover, RoverStateContext context) {
				
			}
		};
	}

	protected abstract SimpleDirectedRoverState createStateUnderTest(
			RoverState clockwiseState, RoverState counterClockwiseState);
}
