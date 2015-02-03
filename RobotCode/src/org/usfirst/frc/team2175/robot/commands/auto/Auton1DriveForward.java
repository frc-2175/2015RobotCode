package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton1DriveForward extends CommandGroup {
    
    public Auton1DriveForward() {
        addSequential(new ArcadeDriveWithInputs(0.5, 0), 3);
    }
    
}
