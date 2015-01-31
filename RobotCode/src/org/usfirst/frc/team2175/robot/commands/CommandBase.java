package org.usfirst.frc.team2175.robot.commands;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.OI;
import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	protected final Logger log = Logger.getLogger(getClass().getName());
	
	protected void initialize() {
		log.info("Starting command");
	}
	
	protected void end() {
		log.info("Ending command");
	}
	
}
