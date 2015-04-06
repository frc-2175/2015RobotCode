package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Grabs one container and two totes and drives into the auto zone. Start in P2
 * or P3 with the container intake around a container and the tote elevator
 * down.
 */
public class AutonStack2TotesGrab1Container extends CommandGroup {

    public AutonStack2TotesGrab1Container() {

        // Pick up a tote and a container
        addParallel(new CloseContainerIntake());
        addSequential(new IntakeTote());
        addSequential(new MoveToteElevatorWithInputs(0.5), 0.75);
        // FIXME Removed the PID command here. This needs testing
        // addSequential(new MoveToteElevatorToPosition(
        // Robot.properties.toteConfig.stack));

        // Turn and pick up another tote
        addSequential(new TurnDegrees(180));
        addParallel(new IntakeTote());
        addSequential(new DriveInches(36));
        addParallel(new StackTote());

        // Turn and drive to auto zone
        addSequential(new TurnDegrees(-90));
        addSequential(new DriveInches(108));

    }
}
