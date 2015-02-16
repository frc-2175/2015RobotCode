package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonStack3TotesGrab1Container extends CommandGroup {

    // TODO This is really all wrong - write a new one that doesn't need us to
    // drive around containers. (Also, is this even necessary?)

    public AutonStack3TotesGrab1Container() {
        /** TODO check all numbers and if they need to be negated */
        addParallel(new IntakeTote());
        addSequential(new CloseContainerIntake());
        addParallel(new StackTote());
        addSequential(new TurnDegrees(180));
        addParallel(new IntakeTote());
        addSequential(new DriveInches(10));
        addParallel(new StackTote());
        addSequential(new TurnDegrees(-150));
        addSequential(new DriveInches(60));
        addSequential(new TurnDegrees(-60));
        addSequential(new DriveInches(60));
        addSequential(new TurnDegrees(30));
        addParallel(new IntakeTote());
        addSequential(new DriveInches(10));
        addSequential(new TurnDegrees(90));
        addSequential(new DriveInches(108));

    }
}
