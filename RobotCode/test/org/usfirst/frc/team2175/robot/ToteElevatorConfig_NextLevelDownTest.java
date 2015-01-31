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
public class ToteElevatorConfig_NextLevelDownTest {
	
	@Parameters(name = "{index}: current = {0} and expected = {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{5, 10}, {15, 10}, {25, 20}, {35, 30}, {45, 40}, {55, 50} 
		});
	}
	
	@Parameter
	public int currentLevel;
	
	@Parameter(value = 1)
	public int expected;
	
	@Test
	public void testGetNextLevelDown() {
		ToteElevatorConfig config = new ToteElevatorConfig(10, 20, 30, 40, 50);
		
		int actual = config.getNextLevelDown(currentLevel);
		assertEquals("Wrong nextLevelDown found", expected, actual);
	}
	
}
