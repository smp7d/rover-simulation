package org.sample.rover.command;

import org.junit.Test;
import org.sample.rover.entity.Rover;
import org.sample.rover.state.RoverStateContext;
import static org.mockito.Mockito.*;

public class MoveCommandTest {

	@Test
	public void testExecute() {
		RoverStateContext context = mock(RoverStateContext.class);
		MoveCommand command = new MoveCommand();
		Rover rover = new Rover();
		command.execute(rover, context);
		verify(context, times(1)).move(rover);
		verifyNoMoreInteractions(context);
	}
}
