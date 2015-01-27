package org.usfirst.frc.team2175.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
//TODO Finish this, requires other things first
public class Auto3StackToteInAutoZone extends CommandGroup {
    
    public  Auto3StackToteInAutoZone() {
       //Would start in same spot as auto1Drive forward and left, needs more testing on getting to the required location 
      //This is currently only just moving it the same spot from Auton Drive forward
    	addSequential(new ArcadeDriveWithInputs(0.5, 0), 3);
    	
    }
}
