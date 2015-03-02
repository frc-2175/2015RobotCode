package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonDriveForward extends CommandGroup {

    public AutonDriveForward() {
        addSequential(new ArcadeDriveWithInputs(0.5, 0), 2.75); // TODO
                                                                // refine?
                                                                // TODO change
                                                                // this to
                                                                // DriveInches
        // addSequential(new DriveInches(108));
    }

}
