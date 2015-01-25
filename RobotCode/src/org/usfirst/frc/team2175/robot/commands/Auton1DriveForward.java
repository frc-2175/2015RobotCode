package org.usfirst.frc.team2175.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton1DriveForward extends CommandGroup {
    
    public Auton1DriveForward() {
        addSequential(new ArcadeDriveWithInputs(0.5, 0), 3);
    }
    
}
