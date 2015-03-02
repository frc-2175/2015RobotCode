package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Closes container grabber, lifts it a little, then turns 45 degrees in
 * preparation for doNoodle
 */
public class AutonDoNoodleRight extends CommandGroup {

    public AutonDoNoodleRight() {

        addSequential(new CloseContainerIntake());
        addSequential(new MoveContainerElevatorWithInputs(0.75), .6);

        addSequential(new TurnDegrees(45, true));

    }
}
