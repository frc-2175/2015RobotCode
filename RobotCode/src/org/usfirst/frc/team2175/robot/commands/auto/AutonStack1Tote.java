package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorToPosition;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.RunLeftToteIntakeWheelsBackwards;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Picks up one tote and drives into the auto zone. Start in P2, P3, or P4, with
 * the tote elevator all the way down and completely around the tote.
 */
public class AutonStack1Tote extends CommandGroup {

    public AutonStack1Tote() {

        // TODO refine values
//        addSequential(new MoveToteElevatorToPosition(
//                Robot.properties.toteConfig.stack));
        addSequential(new MoveToteElevatorWithInputs(0.5), 0.75);
        
        addParallel(new RunLeftToteIntakeWheelsBackwards(), 2);
    	addSequential(new TurnDegrees(90, true));
    	
        addSequential(new DriveInches(114));

    }
}
