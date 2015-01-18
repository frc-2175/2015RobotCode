package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.OI;
import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.subsystems.ToteSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command{
	
	public static ToteSubsystem toteSubsystem = new ToteSubsystem();
	
	public static void init(){
		Robot.oi = new OI(); 
	}
}
