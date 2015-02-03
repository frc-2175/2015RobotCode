package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveInches extends Command {
	double setpoint;

    public DriveInches(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	setpoint = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.straightDriveController.setSetpoint(setpoint);
    	Robot.drivetrain.straightDriveController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return Robot.drivetrain.straightDriveController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.straightDriveController.disable();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
