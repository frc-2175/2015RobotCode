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
public class AutonStack3TotesGrab1Container extends CommandGroup {
    
    public  AutonStack3TotesGrab1Container() {
        
    	addParallel(new IntakeTote());
    	addSequential(new DriveInches(36)); //TODO refine number
    	addSequential(new DriveInches(-60)); //TODO refine number
    	addSequential(new CloseContainerIntake());
    	addSequential(new TurnDegrees(180));
    	addParallel(new StackTote());
    	addSequential(new DriveInches(36)); //TODO refine number
    	addSequential(new TurnDegrees(150)); //TODO check positive or negative
    	addSequential(new DriveInches(60)); //TODO refine number
    	addSequential(new TurnDegrees(60)); //TODO check positive or negative
    	addSequential(new DriveInches(60)); //TODO refine numbers
    	addSequential(new TurnDegrees(-30)); //TODO check positive or negative
    	addParallel(new StackTote());
    	addSequential(new DriveInches(36)); //TODO refine number
    	addSequential(new TurnDegrees(-90)); //TODO TODO check positive or negative
    	addSequential(new DriveInches(108));
    	addSequential(new DriveInches(-48)); //TODO refine numbers
    	
    }
}
