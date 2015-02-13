package org.usfirst.frc.team2175.robot.commands.single;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveInches extends Command {
    double setpoint;
    private final Logger log = Logger.getLogger(getClass().getName());

    public DriveInches(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        setpoint = inches;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.drivetrain.straightDriveController.setSetpoint(setpoint);
        Robot.drivetrain.straightDriveController.enable();
        log.log(Level.FINE, "Driving for " + setpoint + " inches");

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {

        return Robot.drivetrain.straightDriveController.onTarget();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.drivetrain.straightDriveController.disable();
        log.log(Level.FINE, "Done driving for " + setpoint + " inches");

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
