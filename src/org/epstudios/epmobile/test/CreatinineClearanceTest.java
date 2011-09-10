package org.epstudios.epmobile.test;

import junit.framework.TestCase;
import org.epstudios.epmobile.CreatinineClearance;

public class CreatinineClearanceTest extends TestCase {
	public void testCalculate() {
		assertEquals(0, CreatinineClearance.calculate(true, 0, 0, 0));
		assertEquals(0, CreatinineClearance.calculate(true, 140, 0, 0));
		assertEquals(58, CreatinineClearance.calculate(true, 77, 65, 0.98));
		assertEquals((int) (0.85 * 58), CreatinineClearance.calculate(false, 77, 65, 0.98));
		// next one tests for round off, precise answer is 47.79, should round to 48
		assertEquals(48, CreatinineClearance.calculate(true, 77, 65, 1.19));
		
	}
}
