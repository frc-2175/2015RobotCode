package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorToPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Grabs one container and drive straight into the auto zone. Start between a
 * container and the alliance wall, with the container intake arms open and
 * around a container.
 */
public class AutonGrab1Container extends CommandGroup {

    public AutonGrab1Container() {
        addSequential(new CloseContainerIntake());
        addSequential(new MoveContainerElevatorToPosition(
                Robot.properties.containerConfig.level1));
        addSequential(new DriveInches(108));
    }
}
