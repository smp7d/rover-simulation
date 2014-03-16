package org.sample.rover.simulator;

import static org.mockito.Matchers.anyChar;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Test;
import org.sample.rover.RoverController;
import org.sample.rover.RoverDirective;
import org.sample.rover.StatusCommunicator;
import org.sample.rover.command.RoverCommand;
import org.sample.rover.command.RoverCommandFactory;
import org.sample.rover.entity.Plateau;
import org.sample.rover.entity.Rover;
import org.sample.rover.entity.StatelessRectangularPlateau;
import org.sample.rover.exception.InvalidDirectiveException;
import org.sample.rover.state.NortherlyFacingRoverState;
import org.sample.rover.state.RoverStateContext;
import org.sample.rover.state.RoverStateFactory;

/**
 * Unit test for mars simulator.
 * 
 */
public class MarsRoverSimulatorTest {

	@Test
	public void testAcceptCommand(){
		MarsRoverSimulator marsRoverSimulator = new MarsRoverSimulator();
		RoverCommandFactory roverCommandFactory = mock(RoverCommandFactory.class);
		RoverCommand roverCommand = mock(RoverCommand.class);
		when(roverCommandFactory.buildRoverCommand('D')).thenReturn(roverCommand);
		marsRoverSimulator.setRoverCommandFactory(roverCommandFactory);
		RoverController controller = new RoverController();
		RoverStateContext stateContext = new RoverStateContext();
		Rover rover = new Rover();
		controller.setRover(rover);
		controller.setStateContext(stateContext);
		marsRoverSimulator.acceptCommand('D', controller);
		verify(roverCommand, times(1)).execute(rover, stateContext);
	}
	
	@Test
	public void testBuildController() {
		RoverDirective roverDirective = new RoverDirective("2 1 N", "");

		Plateau plateau = new Plateau() {

			@Override
			public boolean allowsCoordinates(int x, int y) {
				return true;
			}
		};

		StatusCommunicator statusCommunicator = new StatusCommunicator() {
			@Override
			public void communicateStatus(String status) {
			}
		};

		RoverStateFactory roverStateFactory = mock(RoverStateFactory.class);
		when(roverStateFactory.buildState(anyChar())).thenReturn(
				new NortherlyFacingRoverState('X'));

		MarsRoverSimulator marsRoverSimulator = new MarsRoverSimulator();
		marsRoverSimulator.setRoverStateFactory(roverStateFactory);
		RoverController controller = marsRoverSimulator.buildController(
				plateau, roverDirective, statusCommunicator);

		Assert.assertNotNull("Controller doesn't have a state context!",
				controller.getStateContext());

		Assert.assertNotNull("Controller doesn't have access to a rover!",
				controller.getRover());
		Assert.assertNotNull("Rover's coordinates are not set!", controller
				.getRover().getCurrentCoordinates());
		Assert.assertEquals(2, controller.getRover().getCurrentCoordinates()
				.getX());
		Assert.assertEquals(1, controller.getRover().getCurrentCoordinates()
				.getY());

		Assert.assertEquals("The rover is on a mysterious plateau.", plateau,
				controller.getRover().getPlateau());

		Assert
				.assertEquals(
						"The rover has no been set up with the correct communications equipment.",
						statusCommunicator, controller.getRover()
								.getStatusCommunicator());

		verify(roverStateFactory, times(2)).buildState('N');
		verify(roverStateFactory, times(1)).buildState('E');
		verify(roverStateFactory, times(1)).buildState('S');
		verify(roverStateFactory, times(1)).buildState('W');
	}

	@Test
	public void testBuildPlateau() {
		buildPlateauHelper("5 4");
	}

	@Test(expected = InvalidDirectiveException.class)
	public void testBuildPlateau_invalidWidth() {
		buildPlateauHelper("x 4");
	}

	@Test(expected = InvalidDirectiveException.class)
	public void testBuildPlateau_invalidHeight() {
		buildPlateauHelper("5 y");
	}

	@Test(expected = InvalidDirectiveException.class)
	public void testBuildPlateau_invalidFormat() {
		buildPlateauHelper("blah");
	}

	private void buildPlateauHelper(String directive) {
		MarsRoverSimulator simulator = new MarsRoverSimulator();
		Plateau plateau = simulator.buildPlateau(directive);
		Assert
				.assertTrue(
						"Plateaus on Mars are supposed to be stateless and rectangular!",
						plateau instanceof StatelessRectangularPlateau);
		Assert.assertEquals(((StatelessRectangularPlateau) plateau).getWidth(),
				5);
		Assert.assertEquals(
				((StatelessRectangularPlateau) plateau).getHeight(), 4);
	}
}
