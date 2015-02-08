package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 *
 */
public class Drivetrain extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public PIDController straightDriveController;
    public PIDController turnController;
    SendableChooser driveChooser;
    Command driveChoice;

    private class StraightDriveControllerHandler implements PIDSource,
            PIDOutput {
        @Override
        public void pidWrite(double output) {
            // Do something with the output PID value, like update motors
            arcadeDrive(output, 0);
        }

        @Override
        public double pidGet() {
            // Return the sensor value for the PID input
            return getMeanEncoderDistance();
        }
    }

    private class TurnControllerHandler implements PIDSource, PIDOutput {
        @Override
        public void pidWrite(double output) {
            // Do something with the output PID value, like update motors
            arcadeDrive(0, output);
        }

        @Override
        public double pidGet() {
            // Return the sensor value for the PID input
            return getGyroHeading();
        }
    }

    public Drivetrain(SendableChooser driveChooser) {
        TurnControllerHandler turnHandler = new TurnControllerHandler();
        turnController = new PIDController(0, 0, 0, turnHandler, turnHandler);
        turnController.setAbsoluteTolerance(.5);

        StraightDriveControllerHandler straightHandler = new StraightDriveControllerHandler();
        straightDriveController = new PIDController(0, 0, 0, straightHandler,
                straightHandler);
        straightDriveController.setAbsoluteTolerance(.5);
        // TODO assign PID values
    }

    public void resetEncoders() {
        RobotMap.leftEncoder.reset();
        RobotMap.rightEncoder.reset();
    }

    public double getMeanEncoderRate() {
        double leftRate = RobotMap.leftEncoder.getRate();
        double rightRate = RobotMap.rightEncoder.getRate();
        double avg = (leftRate + rightRate) / 2;

        log.fine("leftRate=" + leftRate + ", rightRate=" + rightRate
                + ", avgRate=" + avg);
        return avg;
    }

    public double getMeanEncoderDistance() {
        double leftDistance = RobotMap.leftEncoder.getDistance();
        double rightDistance = RobotMap.rightEncoder.getDistance();
        double avg = (leftDistance + rightDistance) / 2;

        log.fine("leftDistance=" + leftDistance + ", rightDistance="
                + rightDistance + ", avgDistance=" + avg);
        return avg;
    }

    public double getGyroHeading() {
        return RobotMap.gyro.getAngle();
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        log.fine("leftSpeed=" + leftSpeed + ", rightSpeed" + rightSpeed);
        RobotMap.drivetrain.tankDrive(rightSpeed, leftSpeed);
    }

    public void arcadeDrive(double moveSpeed, double rotateSpeed) {
        log.fine("moveSpeed=" + moveSpeed + ", rotateSpeed" + rotateSpeed);
        RobotMap.drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        // driveChoice = (Command) driveChooser.getSelected();
        // setDefaultCommand(driveChoice);
    }
}
