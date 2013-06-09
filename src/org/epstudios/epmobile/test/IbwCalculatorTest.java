package org.epstudios.epmobile.test;

import junit.framework.TestCase;

import org.epstudios.epmobile.IbwCalculator;

public class IbwCalculatorTest extends TestCase {

	public IbwCalculatorTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testIdealBodyWeight() {
		double height = 24.0;
		boolean isMale = true;
		assertEquals(IbwCalculator.idealBodyWeight(height, isMale), 50.0, 0.01);
		height = 66.3;
		assertEquals(IbwCalculator.idealBodyWeight(height, isMale), 64.49, 0.01);
		isMale = false;
		assertEquals(IbwCalculator.idealBodyWeight(height, isMale), 59.99, 0.01);
		height = 97.2;
		assertEquals(IbwCalculator.idealBodyWeight(height, isMale), 131.06,
				0.01);
	}

	public void testAdjustedBodyWeight() {
		double ibw = 50.0;
		double actualWeight = 109.55;
		assertEquals(IbwCalculator.adjustedBodyWeight(ibw, actualWeight), 73.8,
				0.1);
		ibw = 64.49;
		assertEquals(IbwCalculator.adjustedBodyWeight(ibw, actualWeight), 82.5,
				0.1);

	}

}
