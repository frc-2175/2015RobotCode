package org.usfirst.frc.team2175.robot;

public class ToteElevatorConfig {
	
	public final int bottom;
	public final int driving;
	public final int scoring;
	public final int step;
	public final int stack;

	public ToteElevatorConfig(int pickup, int driving, int scoring, int step, int stack) throws IllegalStateException {
		if ( !(pickup <= driving && driving <= scoring && scoring <= step && step <= stack) )
			throw new IllegalStateException("Elevator levels are not in order.");
		
		this.bottom = pickup;
		this.driving = driving;
		this.scoring = scoring;
		this.step = step;
		this.stack = stack;
	}
	
	public int getNextLevelUp(int currentLevel) {
		if (currentLevel < bottom)
			return bottom;
		else if (currentLevel < driving)
			return driving;
		else if (currentLevel < scoring)
			return scoring;
		else if (currentLevel < step)
			return step;
		else
			return stack;
	}
	
	public int getNextLevelDown(int currentLevel) {
		if (currentLevel > stack)
			return stack;
		else if (currentLevel > step)
			return step;
		else if (currentLevel > scoring)
			return scoring;
		else if (currentLevel > driving)
			return driving;
		else
			return bottom;
	}

}
