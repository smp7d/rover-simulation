package org.sample.rover.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.sample.rover.entity.Rover;
import org.sample.rover.state.RoverStateContext;

public class SpinLeftCommandTest {

	@Test
	public void testExecute() {
		RoverStateContext context = mock(RoverStateContext.class);
		SpinLeftCommand command = new SpinLeftCommand();
		Rover rover = new Rover();
		command.execute(rover, context);
		verify(context, times(1)).spinLeft(rover);
		verifyNoMoreInteractions(context);
	}
}
