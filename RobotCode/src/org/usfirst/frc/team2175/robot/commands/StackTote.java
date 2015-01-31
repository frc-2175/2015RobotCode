package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StackTote extends CommandGroup {
    
    public StackTote() {
    	
    	addSequential(new IntakeTote());
    	addSequential(new MoveToteElevatorToPosition(Robot.properties.toteConfig.pickup)); 
    	addSequential(new MoveToteElevatorToPosition(Robot.properties.toteConfig.stack));
    }
}
