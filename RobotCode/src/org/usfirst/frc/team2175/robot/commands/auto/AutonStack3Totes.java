package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonStack3Totes extends CommandGroup {

    // TODO This is really all wrong - write a new one that doesn't need us to
    // drive around containers

    public AutonStack3Totes() {
        // TODO refine numbers
        addParallel(new IntakeTote(), 1);
        addSequential(new DriveInches(48));
        addParallel(new IntakeTote(), 1);
        addSequential(new StackTote());
        addSequential(new DriveInches(48));
        addSequential(new IntakeTote(), 1);
        addSequential(new StackTote());
        addSequential(new TurnDegrees(90)); // TODO Check to see if this will
                                            // turn right or left, since the
                                            // gyro does not treat degrees like
                                            // normal math would.
        addSequential(new DriveInches(104));

        // Add Commands here:
        // e.g. addSequential(new Command1());
        // addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        // addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
