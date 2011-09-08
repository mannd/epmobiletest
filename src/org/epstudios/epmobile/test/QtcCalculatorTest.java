package org.epstudios.epmobile.test;

import junit.framework.TestCase;
import org.epstudios.epmobile.QtcCalculator;
import org.epstudios.epmobile.QtcCalculator.QtcFormula;

public class QtcCalculatorTest extends TestCase {

	public QtcCalculatorTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testCalculate() {
		assertEquals(0, QtcCalculator.calculate(0, 0, QtcFormula.BAZETT));
		assertEquals(400, QtcCalculator.calculate(1000, 400, QtcFormula.BAZETT));
	}

}
