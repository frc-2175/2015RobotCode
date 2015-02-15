package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

public class AutonStack1Tote extends CommandGroup {

    public AutonStack1Tote() {
        // Would start in same spot as auto1Drive forward and left, needs more
        // testing on getting to the required location
        // This is currently only just moving it the same spot from Auton Drive
        // forward

        // TODO refine values
        addParallel(new StackTote());
        addSequential(new DriveInches(8));
        addSequential(new TurnDegrees(90));
        addSequential(new DriveInches(108));

    }
}
