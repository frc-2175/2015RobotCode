package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonDriveForward extends CommandGroup {
    
    public AutonDriveForward() {
        addSequential(new ArcadeDriveWithInputs(0.5, 0), 3);
    }
    
}
