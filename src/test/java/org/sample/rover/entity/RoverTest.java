package org.sample.rover.entity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;
import org.sample.rover.StatusCommunicator;
import org.sample.rover.exception.InvalidCoordinatesException;

public class RoverTest {

	@Test
	public void testReportStatus() {
		Rover rover = new Rover();
		rover.setPlateau(new Plateau() {

			@Override
			public boolean allowsCoordinates(int x, int y) {
				return true;
			}
		});

		Random random = new Random();
		int x = random.nextInt();
		int y = random.nextInt();
		rover.setCoordinates(x, y);

		StatusCommunicator communicator = mock(StatusCommunicator.class);
		rover.setStatusCommunicator(communicator);
		char direction = 'X';
		rover.reportStatus(direction);
		verify(communicator, times(1)).communicateStatus(
				x + " " + y + " " + direction);
	}

	@Test
	public void testInitialCoordinates() {
		Rover rover = new Rover();
		rover.setPlateau(new Plateau() {

			@Override
			public boolean allowsCoordinates(int x, int y) {
				return true;
			}
		});
		Random random = new Random();
		int x = random.nextInt();
		int y = random.nextInt();
		rover.setCoordinates(x, y);

		Assert.assertEquals(x, rover.getCurrentCoordinates().getX());
		Assert.assertEquals(y, rover.getCurrentCoordinates().getY());
	}

	@Test(expected = InvalidCoordinatesException.class)
	public void testInitialCoordinates_OffOfPlateau() {
		Rover rover = new Rover();
		rover.setPlateau(new Plateau() {

			@Override
			public boolean allowsCoordinates(int x, int y) {
				return false;
			}
		});
		Random random = new Random();
		int x = random.nextInt();
		int y = random.nextInt();
		rover.setCoordinates(x, y);
	}

	public void moveTest() {
		Rover rover = new Rover();
		rover.setPlateau(new Plateau() {

			@Override
			public boolean allowsCoordinates(int x, int y) {
				return true;
			}
		});
		Random random = new Random();
		int initialX = random.nextInt();
		int initialY = random.nextInt();
		rover.setCoordinates(initialX, initialY);

		int moveX = random.nextInt();
		int moveY = random.nextInt();
		rover.move(moveX, moveY);

		Assert.assertEquals(initialX + moveX, rover.getCurrentCoordinates()
				.getX());
		Assert.assertEquals(initialY + moveY, rover.getCurrentCoordinates()
				.getY());
	}

	@Test(expected = InvalidCoordinatesException.class)
	public void moveTest_MoveOffPlateau() {
		Rover rover = new Rover();
		rover.setPlateau(new Plateau() {

			@Override
			public boolean allowsCoordinates(int x, int y) {
				return x == 0 && y == 0;
			}
		});

		int initialX = 0;
		int initialY = 0;
		rover.setCoordinates(initialX, initialY);

		int moveX = 1;
		int moveY = -1;
		rover.move(moveX, moveY);
	}
}
