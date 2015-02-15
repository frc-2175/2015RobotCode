package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.OpenContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonStack1ToteGrab1Container extends CommandGroup {

    public AutonStack1ToteGrab1Container() {

        // TODO refine values
        addParallel(new StackTote());
        addSequential(new DriveInches(8));
        addSequential(new OpenContainerIntake());
        addSequential(new DriveInches(-16));
        addSequential(new TurnDegrees(90));
        addSequential(new DriveInches(108));
    }
}
