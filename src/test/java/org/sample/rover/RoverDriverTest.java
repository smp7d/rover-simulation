package org.sample.rover;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.mockito.InOrder;
import org.sample.rover.command.RoverCommandFactory;
import org.sample.rover.command.StandardRoverCommandFactory;
import org.sample.rover.exception.InvalidCoordinatesException;
import org.sample.rover.simulator.MarsRoverSimulator;
import org.sample.rover.state.CompassDirectionsRoverStateFactory;
import org.sample.rover.state.RoverStateFactory;

public class RoverDriverTest {

	@Test
	public void testRunSimplePlan_SingleRoverNoMoves() {
		RoverDriver driver = new RoverDriver();
		MarsRoverSimulator roverSimulator = new MarsRoverSimulator();
		RoverStateFactory roverStateFactory = new CompassDirectionsRoverStateFactory();
		roverSimulator.setRoverStateFactory(roverStateFactory);
		RoverCommandFactory roverCommandFactory = new StandardRoverCommandFactory();
		roverSimulator.setRoverCommandFactory(roverCommandFactory);
		driver.setRoverSimulator(roverSimulator);
		driver.setPlateauDirective("5 5").setRoverDirectives(
				new ArrayList<RoverDirective>(Arrays.asList(new RoverDirective(
						"1 2 N", ""))));
		StatusCommunicator printer = mock(StatusCommunicator.class);
		driver.setStatusCommunicator(printer);
		driver.runPlan();

		verify(printer, times(1)).communicateStatus("1 2 N");
		verifyNoMoreInteractions(printer);
	}

	@Test
	public void testRunSimplePlan_SingleRover() {
		RoverDriver driver = new RoverDriver();
		MarsRoverSimulator roverSimulator = new MarsRoverSimulator();
		RoverStateFactory roverStateFactory = new CompassDirectionsRoverStateFactory();
		roverSimulator.setRoverStateFactory(roverStateFactory);
		RoverCommandFactory roverCommandFactory = new StandardRoverCommandFactory();
		roverSimulator.setRoverCommandFactory(roverCommandFactory);
		driver.setRoverSimulator(roverSimulator);
		driver.setPlateauDirective("5 5").setRoverDirectives(
				new ArrayList<RoverDirective>(Arrays.asList(new RoverDirective(
						"1 2 N", "LMLMLMLMMMM"))));
		StatusCommunicator printer = mock(StatusCommunicator.class);
		driver.setStatusCommunicator(printer);
		driver.runPlan();

		verify(printer, times(1)).communicateStatus("1 5 N");
		verifyNoMoreInteractions(printer);
	}

	@Test(expected = InvalidCoordinatesException.class)
	public void testRunSimplePlan_SingleRoverBadInitialCoords() {
		RoverDriver driver = new RoverDriver();
		MarsRoverSimulator roverSimulator = new MarsRoverSimulator();
		RoverStateFactory roverStateFactory = new CompassDirectionsRoverStateFactory();
		roverSimulator.setRoverStateFactory(roverStateFactory);
		RoverCommandFactory roverCommandFactory = new StandardRoverCommandFactory();
		roverSimulator.setRoverCommandFactory(roverCommandFactory);
		driver.setRoverSimulator(roverSimulator);
		driver.setPlateauDirective("5 5").setRoverDirectives(
				new ArrayList<RoverDirective>(Arrays.asList(new RoverDirective(
						"0 6 N", ""))));
		StatusCommunicator printer = mock(StatusCommunicator.class);
		driver.setStatusCommunicator(printer);
		driver.runPlan();
	}
	
	@Test(expected = InvalidCoordinatesException.class)
	public void testRunSimplePlan_SingleRoverMoveOffPlateau() {
		RoverDriver driver = new RoverDriver();
		MarsRoverSimulator roverSimulator = new MarsRoverSimulator();
		RoverStateFactory roverStateFactory = new CompassDirectionsRoverStateFactory();
		roverSimulator.setRoverStateFactory(roverStateFactory);
		RoverCommandFactory roverCommandFactory = new StandardRoverCommandFactory();
		roverSimulator.setRoverCommandFactory(roverCommandFactory);
		driver.setRoverSimulator(roverSimulator);
		driver.setPlateauDirective("5 5").setRoverDirectives(
				new ArrayList<RoverDirective>(Arrays.asList(new RoverDirective(
						"0 5 N", "M"))));
		StatusCommunicator printer = mock(StatusCommunicator.class);
		driver.setStatusCommunicator(printer);
		driver.runPlan();
	}

	@Test
	public void testRunSimplePlan_TwoRovers() {
		RoverDriver driver = new RoverDriver();
		MarsRoverSimulator roverSimulator = new MarsRoverSimulator();
		RoverStateFactory roverStateFactory = new CompassDirectionsRoverStateFactory();
		roverSimulator.setRoverStateFactory(roverStateFactory);
		RoverCommandFactory roverCommandFactory = new StandardRoverCommandFactory();
		roverSimulator.setRoverCommandFactory(roverCommandFactory);
		driver.setRoverSimulator(roverSimulator);
		driver.setPlateauDirective("5 5").setRoverDirectives(
				new ArrayList<RoverDirective>(Arrays.asList(new RoverDirective(
						"1 2 N", "LMLMLMLMM"), new RoverDirective("3 3 E",
						"MMRMMRMRRM"))));
		StatusCommunicator printer = mock(StatusCommunicator.class);
		driver.setStatusCommunicator(printer);
		driver.runPlan();

		InOrder inOrder = inOrder(printer);
		inOrder.verify(printer, times(1)).communicateStatus("1 3 N");
		inOrder.verify(printer, times(1)).communicateStatus("5 1 E");
		verifyNoMoreInteractions(printer);
	}

	@Test
	public void testRunSimplePlan_ThreeRovers() {
		RoverDriver driver = new RoverDriver();
		MarsRoverSimulator roverSimulator = new MarsRoverSimulator();
		RoverStateFactory roverStateFactory = new CompassDirectionsRoverStateFactory();
		roverSimulator.setRoverStateFactory(roverStateFactory);
		RoverCommandFactory roverCommandFactory = new StandardRoverCommandFactory();
		roverSimulator.setRoverCommandFactory(roverCommandFactory);
		driver.setRoverSimulator(roverSimulator);
		driver.setPlateauDirective("5 5").setRoverDirectives(
				new ArrayList<RoverDirective>(Arrays.asList(new RoverDirective(
						"1 2 N", "LMLMLMLMM"), new RoverDirective("3 3 E",
						"MMRMMRMRRM"), new RoverDirective("3 3 E", ""))));
		StatusCommunicator printer = mock(StatusCommunicator.class);
		driver.setStatusCommunicator(printer);
		driver.runPlan();

		InOrder inOrder = inOrder(printer);
		inOrder.verify(printer, times(1)).communicateStatus("1 3 N");
		inOrder.verify(printer, times(1)).communicateStatus("5 1 E");
		inOrder.verify(printer, times(1)).communicateStatus("3 3 E");
		verifyNoMoreInteractions(printer);
	}
}
