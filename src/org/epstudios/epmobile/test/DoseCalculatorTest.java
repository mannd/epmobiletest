package org.epstudios.epmobile.test;

import junit.framework.TestCase;
import org.epstudios.epmobile.DoseCalculator;

public class DoseCalculatorTest extends TestCase {
	public void testWeeklyDosesZero() {
		DoseCalculator d = new DoseCalculator(0, 0);
		double[] result = d.weeklyDoses();
		assertTrue(resultIsZero(result));
	}
	
	private Boolean resultIsZero(double[] result) {
		double num = 0.0;
		for (int i = 0; i < result.length; ++i)
			num = num + result[i];
		return num == 0.0;
	}
	
	public void testWeeklyDosesEqual() {
		DoseCalculator d = new DoseCalculator(5, 35);
		double[] result = d.weeklyDoses();
		for (int i = 0; i < result.length; ++i)
			assertEquals(1.0, result[i]);
		d.setWeeklyDose(70);
		result = d.weeklyDoses();
		for (int i = 0; i < result.length; ++i)
			assertEquals(2.0, result[i]);
		d.setTabletDose(2.5);
		result = d.weeklyDoses();
		for (int i = 0; i < result.length; ++i)
			assertEquals(4.0, result[i]);
	}
	
	public void testTabletDoseTooHigh() {
		DoseCalculator d = new DoseCalculator(10, 20);
		double[] result = d.weeklyDoses();
		assertTrue(resultIsZero(result));
	}
	
	public void testActualWeelyDose() {
		DoseCalculator d = new DoseCalculator(2.5, 30);
		double doses[] = {1, 2, 2, 3.5, 7 };
		assertEquals(d.actualWeeklyDose(doses), 38.75);
		double doses2[] = {1, 1, 1};
		assertEquals(d.actualWeeklyDose(doses2), 7.5);
	}
	

	
}