package org.epstudios.epmobile.test;

import org.epstudios.epmobile.UnitConverter;

import junit.framework.TestCase;

public class UnitConverterTest extends TestCase {

	public UnitConverterTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testWeightConversion() {
		assertEquals(2.2, UnitConverter.kgsToLbs(1), 0.1);
		assertEquals(101.41, UnitConverter.kgsToLbs(46), 0.1);
		assertEquals(0, UnitConverter.kgsToLbs(0), 0.1);
		assertEquals(91, UnitConverter.lbsToKgs(200.61), 0.01);
		assertEquals(100, UnitConverter.lbsToKgs(220.46), 0.01);
	}

}
