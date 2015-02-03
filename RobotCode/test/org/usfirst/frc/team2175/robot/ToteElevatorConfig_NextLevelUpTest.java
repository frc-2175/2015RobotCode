package org.usfirst.frc.team2175.robot;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ToteElevatorConfig_NextLevelUpTest extends TestBase {
	
	@Parameters(name = "{index}: current = {0} and expected = {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{5, 10}, {15, 20}, {25, 30}, {35, 40}, {45, 50}, {55, 50},
				{9, 20}, {19, 30}, {29, 40}, {39, 50}, {49, 50}
		});
	}
	
	@Parameter
	public double currentLevel;
	
	@Parameter(value = 1)
	public double expected;
	
	@Test
	public void testGetNextLevelUp() {
		ToteElevatorConfig config = new ToteElevatorConfig(10, 20, 30, 40, 50);
		
		double actual = config.getNextLevelUp(currentLevel);
		assertEquals("Wrong nextLevelUp found", expected, actual, DOUBLE_TOLERANCE);
	}
	
}
