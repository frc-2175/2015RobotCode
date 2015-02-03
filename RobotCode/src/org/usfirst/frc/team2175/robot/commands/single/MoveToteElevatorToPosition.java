package org.usfirst.frc.team2175.robot.commands.single;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class MoveToteElevatorToPosition extends CommandBase {
		
	private double setpoint;
	
    public MoveToteElevatorToPosition(double setpoint) {
    	requires(Robot.toteElevator);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	super.initialize();
    	log.info("Moving elevator to position " + setpoint);
    	
    	Robot.toteElevator.heightController.setSetpoint(setpoint);
    	Robot.toteElevator.heightController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.toteElevator.heightController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	super.end();
    	
    	Robot.toteElevator.heightController.onTarget();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
