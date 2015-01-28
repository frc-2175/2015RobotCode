package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StackTote extends CommandGroup {
    
	double toteElevatorGroundPosition;
	double toteElevatorStackPosition;
	
    public StackTote() {
    	
    	toteElevatorStackPosition = Robot.properties.getToteElevatorStackPosition();
    	toteElevatorGroundPosition = Robot.properties.getToteElevatorGroundPosition();
    	
    	addSequential(new IntakeTote());
    	addSequential(new MoveToteElevatorToPosition(toteElevatorGroundPosition)); 
    	addSequential(new MoveToteElevatorToPosition(toteElevatorStackPosition));
    }
}
