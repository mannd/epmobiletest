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
		assertEquals(460, QtcCalculator.calculate(863, 427, QtcFormula.BAZETT));
	}
	
	public void testCalculateFridericia() {
		assertEquals(0, QtcCalculator.calculate(0, 0, QtcFormula.FRIDERICIA));
		assertEquals(400, QtcCalculator.calculate(1000, 400, QtcFormula.FRIDERICIA));
		assertEquals(448, QtcCalculator.calculate(863, 427, QtcFormula.FRIDERICIA));
	}
	
	public void testCalculateSagie() {
		assertEquals(154, QtcCalculator.calculate(0, 0, QtcFormula.SAGIE));
		assertEquals(400, QtcCalculator.calculate(1000, 400, QtcFormula.SAGIE));
		assertEquals(448, QtcCalculator.calculate(863, 427, QtcFormula.SAGIE));
	}

}
