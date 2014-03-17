package org.sample.rover.entity;

public class StatelessRectangularPlateau implements Plateau {
	private final int maxX;
	private final int maxY;

	public StatelessRectangularPlateau(final int maxX, final int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	@Override
	public boolean allowsCoordinates(int x, int y) {
		return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
	}

}
