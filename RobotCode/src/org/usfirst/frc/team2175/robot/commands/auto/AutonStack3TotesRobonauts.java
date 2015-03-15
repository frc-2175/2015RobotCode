package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonStack3TotesRobonauts extends CommandGroup {
	
	public AutonStack3TotesRobonauts() {
		
		addSequential(new TurnDegrees(-30));
    	addSequential(new DriveInches(8));
    	addSequential(new DriveInches(-8));
		addSequential(new TurnDegrees(0));
		addSequential(new DriveInches(85));
		addSequential(new TurnDegrees(-30));
		addSequential(new DriveInches(8));
    	addSequential(new DriveInches(-8));
		addSequential(new TurnDegrees(0));
		addSequential(new DriveInches(85));
		addSequential(new TurnDegrees(-30));
		addSequential(new DriveInches(8));
    	addSequential(new DriveInches(-8));
		addSequential(new TurnDegrees(45));
		addSequential(new DriveInches(102));
		addSequential(new DriveInches(-60));
		
	}
}
