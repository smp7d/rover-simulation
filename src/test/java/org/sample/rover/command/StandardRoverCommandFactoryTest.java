package org.sample.rover.command;

import junit.framework.Assert;

import org.junit.Test;

public class StandardRoverCommandFactoryTest {
	@Test
	public void testBuildSpinLeftCommand() {
		verifyBuild('L', SpinLeftCommand.class);
	}

	@Test
	public void testBuildSpinRightCommand() {
		verifyBuild('R', SpinRightCommand.class);
	}

	@Test
	public void testBuildMoveCommand() {
		verifyBuild('M', MoveCommand.class);
	}

	@Test
	public void testBuildStatusReportCommand() {
		verifyBuild(RoverCharacterCommands.PRINT, StatusReportCommand.class);
	}

	private void verifyBuild(char command, Class<? extends RoverCommand> clazz) {
		StandardRoverCommandFactory factory = new StandardRoverCommandFactory();
		RoverCommand roverCommand = factory.buildRoverCommand(command);
		Assert.assertNotNull(roverCommand);
		Assert.assertTrue(clazz.isInstance(roverCommand));
		// make sure we are caching
		Assert.assertEquals(roverCommand, factory.buildRoverCommand(command));
	}
}
