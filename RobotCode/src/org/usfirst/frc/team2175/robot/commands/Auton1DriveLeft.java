package org.usfirst.frc.team2175.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton1DriveLeft extends CommandGroup {
    
    public  Auton1DriveLeft() {
    	addSequential(new ArcadeDriveWithInputs(0.5, 0), 3);
    }
}
