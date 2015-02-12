package org.usfirst.frc.team2175.robot.commands.auto;


import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonStack3Totes extends CommandGroup {
    
    public  AutonStack3Totes() {
    	addParallel(new StackTote());
    	addSequential(new DriveInches(8));//TODO Refine Numbers
    	addSequential(new TurnDegrees(30));
    	addSequential(new DriveInches(14));//TODO Refine Numbers
    	addSequential(new TurnDegrees(-60));
    	addSequential(new DriveInches(5));//TODO Refine Numbers
    	addSequential(new TurnDegrees(30));
    	addSequential(new DriveInches(11));//TODO Refine Numbers
    	addParallel(new StackTote());
    	addSequential(new DriveInches(8));//TODO Refine Numbers
    	addSequential(new TurnDegrees(30));
    	addSequential(new DriveInches(14));//TODO Refine Numbers
    	addSequential(new TurnDegrees(-60));
    	addSequential(new DriveInches(5));//TODO Refine Numbers
    	addSequential(new TurnDegrees(30));
    	addSequential(new DriveInches(11));//TODO Refine Numbers
    	addParallel(new StackTote());
    	addSequential(new DriveInches(8));//TODO Refine Numbers
    	addSequential(new TurnDegrees(30));
    	addSequential(new DriveInches(14));//TODO Refine Numbers
    	addSequential(new TurnDegrees(-60));
    	addSequential(new DriveInches(5));//TODO Refine Numbers
    	addSequential(new TurnDegrees(30));
    	addSequential(new DriveInches(11));//TODO Refine Numbers
    	addSequential(new TurnDegrees(90));
    	addSequential(new DriveInches(104));//TODO Refine Numbers
    	
    	
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
