package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class MoveToteElevatorToPosition extends Command {
	double setpoint;

	private double position;
    public MoveToteElevatorToPosition(double position) {

    	requires(Robot.pidToteElevator);
    	this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pidToteElevator.setSetpoint(setpoint);
    	Robot.pidToteElevator.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pidToteElevator.setSetpoint(position);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.toteElevator.heightController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteElevator.heightController.onTarget();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
