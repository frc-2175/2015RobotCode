package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutonStack3TotesGrab1Container extends CommandGroup {

    public AutonStack3TotesGrab1Container() {
        /** TODO check all numbers and if they need to be negated */
        addParallel(new CloseContainerIntake());
        addSequential(new IntakeTote());
        addSequential(new WaitCommand(.25));
        addParallel(new MoveContainerElevatorWithInputs(1), 1.5);
        addParallel(new MoveToteElevatorWithInputs(.5), 2);
        addSequential(new WaitCommand(.5));
        addSequential(new TurnDegrees(-180)); // Good up to here
        // addSequential(new OpenContainerIntake());
        // addParallel(new IntakeTote());
        // addSequential(new DriveInches(10));
        // addParallel(new StackTote());
        // addSequential(new TurnDegrees(-180));
        // addSequential(new DriveInches(60));
        // addSequential(new CloseContainerIntake());
        // addParallel(new MoveContainerElevatorWithInputs(.5), .5);
        // addSequential(new TurnDegrees(180));
        // addSequential(new DriveInches(10));
        // addParallel(new IntakeTote());
        // addParallel(new StackTote());
        // addSequential(new TurnDegrees(90));
        // addSequential(new DriveInches(108));

    }
}
