package org.usfirst.frc.team2175.robot;

import org.junit.Test;

public class ToteElevatorConfigTest {
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalStateException.class)
	public void testInvalidOrder() {
		ToteElevatorConfig config = new ToteElevatorConfig(50, 40, 30, 20, 10);
	}

}
