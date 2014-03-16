package org.sample.rover.state;

import org.junit.Test;
import org.sample.rover.entity.Rover;
import static org.mockito.Mockito.*;
public class EasterlyFacingRoverStateTest{

	@Test
	public void testMove(){
		Rover rover = mock(Rover.class);
		EasterlyFacingRoverState state = new EasterlyFacingRoverState('X');
		state.move(rover, null);
		verify(rover, times(1)).move(1, 0);
	}
}
