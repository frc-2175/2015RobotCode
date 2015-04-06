package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Grabs one container and drive straight into the auto zone. Start between a
 * container and the alliance wall, with the container intake arms open and
 * around a container.
 */
public class AutonGrabContainerOnly extends CommandGroup {

    public AutonGrabContainerOnly() {
        // FIXME evaluate strategic value of movement

        addSequential(new CloseContainerIntake());
        addSequential(new MoveContainerElevatorWithInputs(0.75), 1.5);
    }
}
