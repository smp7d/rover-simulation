package org.sample.rover.entity;

public class StatelessRectangularPlateau implements Plateau {
	private final int width;
	private final int height;

	public StatelessRectangularPlateau(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
