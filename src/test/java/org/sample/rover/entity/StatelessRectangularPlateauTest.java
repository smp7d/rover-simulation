package org.sample.rover.entity;

import junit.framework.Assert;

import org.junit.Test;

public class StatelessRectangularPlateauTest {

	@Test
	public void testAllowsCoordinates() {
		int width = 4;
		int height = 5;
		StatelessRectangularPlateau plateau = new StatelessRectangularPlateau(
				width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Assert.assertTrue("Plateau should allow [" + x + "," + y + "]",
						plateau.allowsCoordinates(x, y));
			}
		}

		verifyDoesntAllow(-1, height, plateau);
		verifyDoesntAllow(width, -1, plateau);
		verifyDoesntAllow(width + 1, 0, plateau);
		verifyDoesntAllow(0, height + 1, plateau);
	}

	private void verifyDoesntAllow(int x, int y,
			StatelessRectangularPlateau plateau) {
		Assert.assertFalse("Plateau shouldn't allow [" + x + "," + y + "]",
				plateau.allowsCoordinates(x, y));
	}
}
