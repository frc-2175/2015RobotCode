package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.OpenContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton4Stack1ToteGrab1Container extends CommandGroup {
    
    public  Auton4Stack1ToteGrab1Container() {
    	addParallel(new StackTote());
    	addSequential(new DriveInches(8));
    	addSequential(new OpenContainerIntake());
    	addSequential(new DriveInches(-16));
    	addSequential(new TurnDegrees(90));
    	addSequential(new DriveInches(108)); //TODO find good number for this
    }
}
