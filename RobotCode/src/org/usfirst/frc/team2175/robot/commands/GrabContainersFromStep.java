package org.usfirst.frc.team2175.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
//TODO Needs finshing and testing
public class GrabContainersFromStep extends CommandGroup {
    
    public  GrabContainersFromStep() {
    	addSequential(new ArcadeDriveWithInputs(0.5, 0), 3);
    }
}