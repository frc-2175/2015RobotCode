package org.usfirst.frc.team2175.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StackTote extends CommandGroup {
    
    public StackTote() {
    	addSequential(new IntakeTote());
    		//TODO assign a position once positions are assigned within the command.
    	addSequential(new MoveToteElevatorToPosition());
    		//TODO assign a position once positions are assigned within the command.
    	addSequential(new MoveToteElevatorToPosition());
    		//TODO assign a position once positions are assigned within the command.
    }
}
