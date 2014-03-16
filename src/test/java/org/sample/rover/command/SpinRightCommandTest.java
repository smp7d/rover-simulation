package org.sample.rover.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.sample.rover.entity.Rover;
import org.sample.rover.state.RoverStateContext;

public class SpinRightCommandTest {

	@Test
	public void testExecute() {
		RoverStateContext context = mock(RoverStateContext.class);
		SpinRightCommand command = new SpinRightCommand();
		Rover rover = new Rover();
		command.execute(rover, context);
		verify(context, times(1)).spinRight(rover);
		verifyNoMoreInteractions(context);
	}
}
