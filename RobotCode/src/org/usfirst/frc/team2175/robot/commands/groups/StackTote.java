package org.usfirst.frc.team2175.robot.commands.groups;

import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StackTote extends CommandGroup {

    public StackTote() {

        addSequential(new MoveToteElevatorWithInputs(-.3), 1);
        addSequential(new MoveToteElevatorWithInputs(.5), 1);
    }
}
