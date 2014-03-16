package org.sample.rover.entity;

import org.sample.rover.StatusCommunicator;
import org.sample.rover.exception.InvalidCoordinatesException;

public class Rover {
	private Coordinates currentCoordinates;
	private Plateau plateau;
	private StatusCommunicator statusCommunicator;

	public Rover() {
		currentCoordinates = new Coordinates();
	}

	public void move(int moveX, int moveY) {
		setCoordinates(currentCoordinates.getX() + moveX, currentCoordinates
				.getY()
				+ moveY);
	}

	public void setCoordinates(int x, int y) {
		if (plateau.allowsCoordinates(x, y)) {
			currentCoordinates.setX(x);
			currentCoordinates.setY(y);
		} else {
			// we could inject a strategy in the rover to handle differently
			// (ex/ ignore the bad directive)
			throw new InvalidCoordinatesException("Rover cannot move to [" + x
					+ "," + y + "]");
		}
	}

	public Coordinates getCurrentCoordinates() {
		return currentCoordinates;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setStatusCommunicator(StatusCommunicator statusCommunicator) {
		this.statusCommunicator = statusCommunicator;
	}

	public StatusCommunicator getStatusCommunicator() {
		return statusCommunicator;
	}

	public static class Coordinates {
		private int x, y;

		public void setY(int y) {
			this.y = y;
		}

		public int getY() {
			return y;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getX() {
			return x;
		}
	}
}
