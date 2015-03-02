package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Grabs one container and drive straight into the auto zone. Start between a
 * container and the alliance wall, with the container intake arms open and
 * around a container.
 */
public class AutonGrab1Container extends CommandGroup {

    public AutonGrab1Container() {
        addSequential(new CloseContainerIntake());
        addSequential(new MoveContainerElevatorWithInputs(0.75), .6);
        addSequential(new ArcadeDriveWithInputs(.8, 0), 1);
        addSequential(new ArcadeDriveWithInputs(.4, 0), 2.5);
        addSequential(new TurnDegrees(90, true));
    }
}
