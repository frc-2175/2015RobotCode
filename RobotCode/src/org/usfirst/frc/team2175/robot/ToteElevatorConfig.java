package org.usfirst.frc.team2175.robot;

public class ToteElevatorConfig {
	
	public final double pickup;
	public final double driving;
	public final double scoring;
	public final double step;
	public final double stack;

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
		if (currentLevel < pickup)
			return pickup;
		else if (currentLevel < driving)
			return driving;
		else if (currentLevel < scoring)
			return scoring;
		else if (currentLevel < step)
			return step;
		else
			return stack;
	}
	
	public double getNextLevelDown(double currentLevel) {
		if (currentLevel > stack)
			return stack;
		else if (currentLevel > step)
			return step;
		else if (currentLevel > scoring)
			return scoring;
		else if (currentLevel > driving)
			return driving;
		else
			return pickup;
	}

}
