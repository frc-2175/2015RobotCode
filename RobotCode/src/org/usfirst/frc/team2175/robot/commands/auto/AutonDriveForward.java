package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.DriveInches;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonDriveForward extends CommandGroup {
    
    public AutonDriveForward() {
        addSequential(new DriveInches(108)); //TODO refine?
    }
    
}
