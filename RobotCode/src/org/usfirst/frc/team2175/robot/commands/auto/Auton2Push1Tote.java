package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton2Push1Tote extends CommandGroup {
    
    public  Auton2Push1Tote() {
    	
    	//TODO refine numbers
    	addSequential(new ArcadeDriveWithInputs(1,0),2);
    	addSequential(new ArcadeDriveWithInputs(0,1),1);
    	addSequential(new ArcadeDriveWithInputs(1,0),10);
    	
    	
      
    }
}
