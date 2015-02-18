package org.usfirst.frc.team2175.robot.commands.single;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class TurnDegrees extends CommandBase {
    double setpoint;
    private final Logger log = Logger.getLogger(getClass().getName());

    /**
     * Sets the PID setpoint equal to the parameter "degrees"
     *
     * @param degrees
     *            : The absolute angle to turn to
     */
    public TurnDegrees(double degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        setpoint = degrees;
    }

    /**
     * Sets the PID setpoint equal to the parameter "degrees"
     *
     * @param degrees
     *            : The angle to turn to
     * @param isRelative
     *            : Determines whether to calculate the angle as absolute or
     *            relative to the starting position
     */
    public TurnDegrees(double degrees, boolean isRelative) {
        requires(Robot.drivetrain);
        if (isRelative) {
            setpoint = RobotMap.gyro.getAngle() + degrees;
        } else {
            setpoint = degrees;
        }
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
        Robot.drivetrain.turnController.setSetpoint(setpoint);
        Robot.drivetrain.turnController.enable();
        log.log(Level.FINE, "Turing to " + setpoint + " degrees");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.drivetrain.turnController.onTarget();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        super.end();
        Robot.drivetrain.turnController.disable();
        log.log(Level.FINE, "Done turing to " + setpoint + " degrees");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
