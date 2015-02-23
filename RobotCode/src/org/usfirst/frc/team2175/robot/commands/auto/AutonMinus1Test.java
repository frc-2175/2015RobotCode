package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.ZeroToteElevator;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorToPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutonMinus1Test extends CommandGroup {

    public AutonMinus1Test() {

        addSequential(new ZeroToteElevator());
        addSequential(new MoveToteElevatorToPosition(
                Robot.properties.toteConfig.stack));
        addSequential(new WaitCommand(1000));
        addSequential(new MoveToteElevatorToPosition(
                Robot.properties.toteConfig.driving));

    }
}
