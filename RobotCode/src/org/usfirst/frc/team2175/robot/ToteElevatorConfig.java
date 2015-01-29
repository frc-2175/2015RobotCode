package org.usfirst.frc.team2175.robot;

public class ToteElevatorConfig {
	
	public final int bottom;
	public final int driving;
	public final int step;
	public final int top;

	public ToteElevatorConfig(int bottom, int driving, int step, int top) throws IllegalStateException {
		if ( !(bottom < driving && driving < step && step < top) )
			throw new IllegalStateException("Elevator levels are not in order.");
		
		this.bottom = bottom;
		this.driving = driving;
		this.step = step;
		this.top = top;
	}
	
	public int getNextLevelUp(int currentLevel) {
		if (currentLevel < bottom)
			return bottom;
		else if (currentLevel < driving)
			return driving;
		else if (currentLevel < step)
			return step;
		else
			return top;
	}
	
	public int getNextLevelDown(int currentLevel) {
		if (currentLevel > top)
			return top;
		else if (currentLevel > step)
			return step;
		else if (currentLevel > driving)
			return driving;
		else
			return bottom;
	}

}
