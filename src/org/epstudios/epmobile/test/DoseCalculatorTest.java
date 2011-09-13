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
	}
	
	public void testTabletDoseTooHigh() {
		DoseCalculator d = new DoseCalculator(10, 20);
		double[] result = d.weeklyDoses();
		assertTrue(resultIsZero(result));
	}
	
	public void testActualWeeklyDose() {
		DoseCalculator d = new DoseCalculator(2.5, 30);
		double doses[] = {1, 2, 2, 3.5, 7 };
		assertEquals(d.actualWeeklyDose(doses), 38.75);
		double doses2[] = {1, 1, 1};
		assertEquals(d.actualWeeklyDose(doses2), 7.5);
	}
	
	public void testRealDoses() {
		DoseCalculator d = new DoseCalculator(5.0, 40.0);
		double result[] = d.weeklyDoses();
		assertEquals(d.actualWeeklyDose(result), 40.0);
		// some tests from predefined tables in references
		d.setTabletDose(2.0);
		d.setWeeklyDose(11.0);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(0.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(0.5, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(0.5, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
		d.setWeeklyDose(16.0);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(1.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(1.0, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(1.5, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
		d.setWeeklyDose(17.0);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(1.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(1.5, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(1.5, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
		d.setTabletDose(2.5);
		d.setWeeklyDose(18.75);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(1.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(1.0, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(1.0, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
		d.setTabletDose(5.0);
		d.setWeeklyDose(42.5);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(1.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(1.5, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(1.5, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
		d.setWeeklyDose(32.5);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(0.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(1.0, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(1.0, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
		d.setTabletDose(7.5);
		d.setWeeklyDose(41.25);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(0.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(0.5, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(0.5, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
		d.setWeeklyDose(56.25);
		result = d.weeklyDoses();
		assertEquals(1.0, result[DoseCalculator.SUN]);
		assertEquals(1.5, result[DoseCalculator.MON]);
		assertEquals(1.0, result[DoseCalculator.TUE]);
		assertEquals(1.0, result[DoseCalculator.WED]);
		assertEquals(1.0, result[DoseCalculator.THU]);
		assertEquals(1.0, result[DoseCalculator.FRI]);
		assertEquals(1.0, result[DoseCalculator.SAT]);
	}
	
}
