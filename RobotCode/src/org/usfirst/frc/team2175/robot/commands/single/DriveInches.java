package org.usfirst.frc.team2175.robot.commands.single;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class DriveInches extends CommandBase {
    double setpoint;
    private final Logger log = Logger.getLogger(getClass().getName());

    public DriveInches(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        setpoint = inches;
        log.log(Level.FINER, "Constructed DriveForInches(" + inches + ")");

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
        Robot.drivetrain.resetEncoders();
        Robot.drivetrain.straightDriveController.setSetpoint(setpoint);
        Robot.drivetrain.setSafetyEnabled(false);
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
        super.end();
        Robot.drivetrain.straightDriveController.disable();
        Robot.drivetrain.setSafetyEnabled(true);

        log.log(Level.FINE, "Done driving for " + setpoint + " inches");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
