package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton2Push3Totes extends CommandGroup {
    
    public  Auton2Push3Totes() {
    	//TODO refine numbers
    	addSequential(new ArcadeDriveWithInputs(1,0),2);
    	addSequential(new ArcadeDriveWithInputs(0,1),1);
    	addSequential(new ArcadeDriveWithInputs(1,0),3);
    	addSequential(new ArcadeDriveWithInputs(0,1),2);
    	addSequential(new ArcadeDriveWithInputs(1,0),2);
    	addSequential(new ArcadeDriveWithInputs(0,1),1);
    	addSequential(new ArcadeDriveWithInputs(1,0),3);
    	addSequential(new ArcadeDriveWithInputs(0,1),2);
    	addSequential(new ArcadeDriveWithInputs(1,0),2);
    	addSequential(new ArcadeDriveWithInputs(0,1),1);
    	addSequential(new ArcadeDriveWithInputs(1,0),3);
    	addSequential(new ArcadeDriveWithInputs(0,1),2);
    	addSequential(new ArcadeDriveWithInputs(1,0),5);
     
    }
}
