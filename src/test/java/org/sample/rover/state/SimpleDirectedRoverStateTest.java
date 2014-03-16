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
				null, 'X');
		Rover rover = null;
		RoverStateContext context = mock(RoverStateContext.class);
		state.spinRight(rover, context);
		verify(context, times(1)).setCurrentState(clockwiseState);
	}

	@Test
	public void testSpinLeft() {
		RoverState counterClockwiseState = createSampleRoverState();
		SimpleDirectedRoverState state = createStateUnderTest(null,
				counterClockwiseState, 'X');
		Rover rover = null;
		RoverStateContext context = mock(RoverStateContext.class);
		state.spinLeft(rover, context);
		verify(context, times(1)).setCurrentState(counterClockwiseState);
	}

	@Test
	public void testReportStatus() {
		char direction = 'X';
		SimpleDirectedRoverState state = createStateUnderTest(null, null,
				direction);
		Rover rover = mock(Rover.class);
		RoverStateContext context = null;
		state.reportStatus(rover, context);
		verify(rover, times(1)).reportStatus(direction);
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

			@Override
			public void reportStatus(Rover rover, RoverStateContext context) {
				// TODO Auto-generated method stub

			}
		};
	}

	protected abstract SimpleDirectedRoverState createStateUnderTest(
			RoverState clockwiseState, RoverState counterClockwiseState,
			char direction);
}
