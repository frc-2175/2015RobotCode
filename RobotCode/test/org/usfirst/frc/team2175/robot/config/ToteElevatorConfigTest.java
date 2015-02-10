package org.usfirst.frc.team2175.robot.config;

import org.junit.Test;
import org.usfirst.frc.team2175.robot.TestBase;
import org.usfirst.frc.team2175.robot.config.ToteElevatorConfig;

public class ToteElevatorConfigTest extends TestBase {
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalStateException.class)
	public void testInvalidOrder() {
		ToteElevatorConfig config = new ToteElevatorConfig(0,50, 40, 30, 20, 10);
	}

}
