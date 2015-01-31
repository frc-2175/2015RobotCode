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

    	requires(Robot.toteElevator);
    	this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.toteElevator.heightController.setSetpoint(setpoint);
    	Robot.toteElevator.heightController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.toteElevator.heightController.setSetpoint(position);
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
