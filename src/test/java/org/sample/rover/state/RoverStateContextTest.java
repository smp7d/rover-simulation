package org.sample.rover.state;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.sample.rover.entity.Rover;

public class RoverStateContextTest {

	@Test
	public void testMove() {
		runTest(new MoveCallingAndVerifyingStrategy());
	}

	@Test
	public void testSpinRight() {
		runTest(new SpinRightCallingAndVerifyingStrategy());
	}

	@Test
	public void testSpinLeft() {
		runTest(new SpinLeftCallingAndVerifyingStrategy());
	}

	@Test
	public void testReportStatus() {
		runTest(new ReportStatusCallingAndVerifyingStrategy());
	}

	private void runTest(SingleContextCallingVerifyingStrategy strategy) {
		RoverState state = mock(RoverState.class);
		RoverStateContext context = new RoverStateContext();
		context.setCurrentState(state);
		Rover rover = null;
		strategy.execute(rover, state, context);
	}

	/**
	 * Since the context is just pass through at this time, these strategies
	 * will reduce code dupe in tests
	 * 
	 */
	private interface SingleContextCallingVerifyingStrategy {
		void execute(Rover rover, RoverState mockedRoverState,
				RoverStateContext context);
	}

	private class ReportStatusCallingAndVerifyingStrategy implements
			SingleContextCallingVerifyingStrategy {

		@Override
		public void execute(Rover rover, RoverState mockedRoverState,
				RoverStateContext context) {
			context.reportStatus(rover);
			verify(mockedRoverState, times(1)).reportStatus(rover, context);
		}

	}

	private class SpinLeftCallingAndVerifyingStrategy implements
			SingleContextCallingVerifyingStrategy {

		@Override
		public void execute(Rover rover, RoverState mockedRoverState,
				RoverStateContext context) {
			context.spinLeft(rover);
			verify(mockedRoverState, times(1)).spinLeft(rover, context);
		}

	}

	private class SpinRightCallingAndVerifyingStrategy implements
			SingleContextCallingVerifyingStrategy {

		@Override
		public void execute(Rover rover, RoverState mockedRoverState,
				RoverStateContext context) {
			context.spinRight(rover);
			verify(mockedRoverState, times(1)).spinRight(rover, context);
		}

	}

	private class MoveCallingAndVerifyingStrategy implements
			SingleContextCallingVerifyingStrategy {

		@Override
		public void execute(Rover rover, RoverState mockedRoverState,
				RoverStateContext context) {
			context.move(rover);
			verify(mockedRoverState, times(1)).move(rover, context);
		}

	}
}
