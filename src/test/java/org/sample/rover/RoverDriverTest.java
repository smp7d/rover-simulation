package org.sample.rover;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.mockito.InOrder;
import org.sample.rover.RoverDriver;

import static org.mockito.Mockito.*;

public class RoverDriverTest {

	@Test
	public void testRunSimplePlan() {
		RoverDriver driver = new RoverDriver();
		driver.setPlateauDirective("5 5")
				.setRoverDirectives(
						new ArrayList<RoverDriver.RoverDirective>(Arrays
								.asList(new RoverDriver.RoverDirective("1 2 N",
										"LMLMLMLMM"),
										new RoverDriver.RoverDirective("3 3 E",
												"MMRMMRMRRM"))));
		PrintStream printer = mock(PrintStream.class);
		driver.setPrinter(printer);
		driver.runPlan();

		InOrder inOrder = inOrder(printer);
		inOrder.verify(printer, times(1)).println("1 3 N");
		inOrder.verify(printer, times(1)).println("5 1 E");
		verifyNoMoreInteractions(printer);
	}

	@Test
	public void testRunSimplePlan_ThreeRovers() {
		RoverDriver driver = new RoverDriver();
		driver.setPlateauDirective("5 5").setRoverDirectives(
				new ArrayList<RoverDriver.RoverDirective>(Arrays.asList(
						new RoverDriver.RoverDirective("1 2 N", "LMLMLMLMM"),
						new RoverDriver.RoverDirective("3 3 E", "MMRMMRMRRM"),
						new RoverDriver.RoverDirective("3 3 E", ""))));
		PrintStream printer = mock(PrintStream.class);
		driver.setPrinter(printer);
		driver.runPlan();

		InOrder inOrder = inOrder(printer);
		inOrder.verify(printer, times(1)).println("1 3 N");
		inOrder.verify(printer, times(1)).println("5 1 E");
		inOrder.verify(printer, times(1)).println("3 3 E");
		verifyNoMoreInteractions(printer);
	}
}
