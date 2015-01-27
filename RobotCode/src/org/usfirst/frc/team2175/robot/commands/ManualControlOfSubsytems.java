package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualControlOfSubsytems extends Command {

	public ManualControlOfSubsytems() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.containerElevator);
		requires(Robot.containerIntake);
		requires(Robot.drivetrain);
		requires(Robot.pidToteElevator);
		requires(Robot.toteElevator);
		requires(Robot.toteIntake);
		requires(Robot.totePusher);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		
		
		
	}

	
	
	

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}