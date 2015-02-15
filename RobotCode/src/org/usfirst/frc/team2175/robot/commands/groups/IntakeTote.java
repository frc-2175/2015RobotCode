package org.usfirst.frc.team2175.robot.commands.groups;

import org.usfirst.frc.team2175.robot.commands.single.CloseToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.OpenToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.RunRightToteIntakeWheels;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeTote extends CommandGroup {

    public IntakeTote() {
        addSequential(new CloseToteIntake());

        // this command assumes that the tote is lined up in front of the
        // intake,
        // so that closing the intake grabs it

        // TODO determine if it is better to start the wheels before or after
        // closing the intake arms.
        addSequential(new RunRightToteIntakeWheels(0));
        addSequential(new RunRightToteIntakeWheels(1));
        addSequential(new OpenToteIntake());
    }
}
