package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonStack2Totes extends CommandGroup {
    public AutonStack2Totes() {

        // P2 CR
        // - or -
        // P3 CR

        // Use this only if the container elevator is broken.

        // TODO refine numbers
        addParallel(new StackTote());
        addSequential(new DriveInches(36));
        addSequential(new TurnDegrees(30));
        addSequential(new DriveInches(70));
        addSequential(new TurnDegrees(-30));
        addParallel(new StackTote());
        addSequential(new DriveInches(30));
        addSequential(new TurnDegrees(90));
        addSequential(new DriveInches(120));
    }
}
