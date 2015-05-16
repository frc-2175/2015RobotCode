package org.usfirst.frc.team2175.robot.commands.groups;

import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class StackTote extends CommandGroup {

    public StackTote() {

    	addSequential(new MoveToteElevatorWithInputs(-.5), 1);
        addParallel(new WaitCommand( 1));
        addParallel(new MoveToteElevatorWithInputs(.8), 3);
        addSequential(new WaitCommand(.6));
    }
}
