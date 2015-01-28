package org.usfirst.frc.team2175.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton2Push2Totes extends CommandGroup {
    
    public  Auton2Push2Totes() {
    	//TODO refine numbers
    	addSequential(new ArcadeDriveWithInputs(1,0),2);
    	addSequential(new ArcadeDriveWithInputs(0,1),1);
    	addSequential(new ArcadeDriveWithInputs(1,0),3);
    	addSequential(new ArcadeDriveWithInputs(0,1),2);
    	addSequential(new ArcadeDriveWithInputs(1,0),2);
    	addSequential(new ArcadeDriveWithInputs(0,1),1);
    	addSequential(new ArcadeDriveWithInputs(1,0),3);
    	addSequential(new ArcadeDriveWithInputs(0,1),2);
    	addSequential(new ArcadeDriveWithInputs(1,0),10);
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
    }
}
