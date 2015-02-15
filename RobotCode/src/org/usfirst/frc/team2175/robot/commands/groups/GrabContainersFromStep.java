package org.usfirst.frc.team2175.robot.commands.groups;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

public class GrabContainersFromStep extends CommandGroup {

    public GrabContainersFromStep() {
        // TODO write the rest of this routine

        addSequential(new ArcadeDriveWithInputs(0.5, 0), 3);
    }
}
