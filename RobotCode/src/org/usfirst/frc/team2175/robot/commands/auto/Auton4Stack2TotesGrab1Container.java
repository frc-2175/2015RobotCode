package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton4Stack2TotesGrab1Container extends CommandGroup {
    
    public  Auton4Stack2TotesGrab1Container() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addParallel(new IntakeTote());
    	addSequential(new DriveInches(36)); //TODO refine number
    	addSequential(new DriveInches(-60)); //TODO refine number
    	addSequential(new CloseContainerIntake());
    	addSequential(new TurnDegrees(180));
    	addParallel(new StackTote());
    	addSequential(new DriveInches(36)); //TODO refine number
    	addSequential(new DriveInches(-60)); //TODO refine number
    	addSequential(new TurnDegrees(90)); //TODO check to see if this needs to be negative
    	addSequential(new DriveInches(108)); //TODO refine number
    	
    }
}
