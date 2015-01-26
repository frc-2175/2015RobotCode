package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.OI;
import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command{
	
	public static void init(){
		Robot.oi = new OI(); 
	}
}
