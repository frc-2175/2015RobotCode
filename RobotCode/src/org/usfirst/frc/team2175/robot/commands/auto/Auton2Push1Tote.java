package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.RunToteIntakeWheels;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton2Push1Tote extends CommandGroup {
    
    public  Auton2Push1Tote() {
    	
    	//TODO refine numbers
    	addParallel(new RunToteIntakeWheels(), 5);
    	addSequential(new DriveInches(36));
    	addSequential(new ArcadeDriveWithInputs(0,1),3);
    	addSequential(new DriveInches(108));
    	
    	
      
    }
}
