package org.usfirst.frc.team2175.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeTote extends CommandGroup {
    
    public  IntakeTote() {
    	addSequential(new CloseToteIntake()); 
    	
    	//this command assumes that the tote is lined up in front of the intake,
    	//so that closing the intake grabs it
    	
        addSequential(new RunToteIntakeWheels()); //TODO determine if it is better to start the wheels before or after closing the intake arms.
        addSequential(new OpenToteIntake());
    }
}
