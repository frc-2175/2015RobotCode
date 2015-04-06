package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Picks up one tote and one container and drives into the auto zone. Start in
 * P2 or P3 with the container intake around a container and the tote elevator
 * down.
 */
public class AutonStack1ToteGrab1Container extends CommandGroup {

    public AutonStack1ToteGrab1Container() {

        // TODO refine values
        addParallel(new CloseContainerIntake());
        addParallel(new MoveContainerElevatorWithInputs(0.75), 1);
        addSequential(new IntakeTote());

        addSequential(new MoveToteElevatorWithInputs(0.5), 1.5);
        // addSequential(new MoveToteElevatorToPosition(
        // Robot.properties.toteConfig.stack));
        addSequential(new TurnDegrees(90, true));
        addSequential(new DriveInches(108));
        addSequential(new TurnDegrees(-90, true));
    }
}
