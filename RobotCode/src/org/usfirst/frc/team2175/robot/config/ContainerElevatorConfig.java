package org.usfirst.frc.team2175.robot.config;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerElevatorConfig extends Subsystem {
	public final double level0;
	public final double level1;
	public final double level2;
	public final double level3;
	public final double level4;
	
	private static final int ACCEPTABLE_RANGE = 2;

	public ContainerElevatorConfig(double level0, double level1, double level2, double level3, double level4) throws IllegalStateException {
		if ( !(level0 <= level1 && level1 <= level2 && level2 <= level3 && level3 <= level4) )
			throw new IllegalStateException("Elevator levels are not in order.");
		
		this.level0 = level0;
		this.level1 = level1;
		this.level2 = level3;
		this.level3 = level3;
		this.level4 = level4;
	}
	
	public double getNextLevelUp(double currentLevel) {
		if (currentLevel < level0 - ACCEPTABLE_RANGE)
			return level0;
		else if (currentLevel < level1 - ACCEPTABLE_RANGE)
			return level1;
		else if (currentLevel < level2 - ACCEPTABLE_RANGE)
			return level2;
		else if (currentLevel < level3 - ACCEPTABLE_RANGE)
			return level3;
		else
			return level4;
	}
	
	public double getNextLevelDown(double currentLevel) {
		if (currentLevel > level4 + ACCEPTABLE_RANGE)
			return level4;
		else if (currentLevel > level3 + ACCEPTABLE_RANGE)
			return level3;
		else if (currentLevel > level2 + ACCEPTABLE_RANGE)
			return level2;
		else if (currentLevel > level1 + ACCEPTABLE_RANGE)
			return level1;
		else
			return level0;
	}

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

