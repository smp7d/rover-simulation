package org.sample.rover.entity;

import junit.framework.Assert;

import org.junit.Test;

public class StatelessRectangularPlateauTest {

	@Test
	public void testAllowsCoordinates() {
		int maxX = 4;
		int maxY = 5;
		StatelessRectangularPlateau plateau = new StatelessRectangularPlateau(
				maxX, maxY);

		for (int x = 0; x <= maxX; x++) {
			for (int y = 0; y <= maxY; y++) {
				Assert.assertTrue("Plateau should allow [" + x + "," + y + "]",
						plateau.allowsCoordinates(x, y));
			}
		}

		verifyDoesntAllow(-1, maxY, plateau);
		verifyDoesntAllow(maxX, -1, plateau);
		verifyDoesntAllow(maxX + 1, 0, plateau);
		verifyDoesntAllow(0, maxY + 1, plateau);
	}

	private void verifyDoesntAllow(int x, int y,
			StatelessRectangularPlateau plateau) {
		Assert.assertFalse("Plateau shouldn't allow [" + x + "," + y + "]",
				plateau.allowsCoordinates(x, y));
	}
}
