package org.usfirst.frc.team2175.robot;

public class ToteElevatorConfig {
	
	public final double pickup;
	public final double driving;
	public final double scoring;
	public final double step;
	public final double stack;
	
	private static final int ACCEPTABLE_RANGE = 2;

	public ToteElevatorConfig(double pickup, double driving, double scoring, double step, double stack) throws IllegalStateException {
		if ( !(pickup <= driving && driving <= scoring && scoring <= step && step <= stack) )
			throw new IllegalStateException("Elevator levels are not in order.");
		
		this.pickup = pickup;
		this.driving = driving;
		this.scoring = scoring;
		this.step = step;
		this.stack = stack;
	}
	
	public double getNextLevelUp(double currentLevel) {
		if (currentLevel < pickup - ACCEPTABLE_RANGE)
			return pickup;
		else if (currentLevel < driving - ACCEPTABLE_RANGE)
			return driving;
		else if (currentLevel < scoring - ACCEPTABLE_RANGE)
			return scoring;
		else if (currentLevel < step - ACCEPTABLE_RANGE)
			return step;
		else
			return stack;
	}
	
	public double getNextLevelDown(double currentLevel) {
		if (currentLevel > stack + ACCEPTABLE_RANGE)
			return stack;
		else if (currentLevel > step + ACCEPTABLE_RANGE)
			return step;
		else if (currentLevel > scoring + ACCEPTABLE_RANGE)
			return scoring;
		else if (currentLevel > driving + ACCEPTABLE_RANGE)
			return driving;
		else
			return pickup;
	}

}
