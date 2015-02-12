package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorToPosition;
import org.usfirst.frc.team2175.robot.commands.single.OpenContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonGrab1Container extends CommandGroup {
    public AutonGrab1Container() {
        addParallel(new OpenContainerIntake());
        addSequential(new DriveInches(-8));
        addSequential(new CloseContainerIntake());
        addSequential(new MoveContainerElevatorToPosition(3));
        addSequential(new TurnDegrees(90));
        addSequential(new DriveInches(108));
    }
}
