package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.ArcadeDriveWithSticks;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	public PIDController straightDriveController;

	private class StraightDriveControllerHandler implements PIDSource,
			PIDOutput {

		@Override
		public void pidWrite(double output) {
			// Do something with the output PID value, like update motors
<<<<<<< HEAD
			arcadeDrive(0,output);
=======
			arcadeDrive(output, 0);
>>>>>>> Polished the tote elevator code. There is still more to be done, but I too care of some small things
		}

		@Override
		public double pidGet() {
			// Return the sensor value for the PID input
			return getMeanEncoderDistance();
		}
	}

	public PIDController turnController;

	private class TurnControllerHandler implements PIDSource, PIDOutput {

		@Override
		public void pidWrite(double output) {
			// Do something with the output PID value, like update motors
			arcadeDrive(0,output);
		}

		@Override
		public double pidGet() {
			// Return the sensor value for the PID input
			return getGyroHeading();
		}
	}

	public Drivetrain() {
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
		return (RobotMap.leftEncoder.getRate() + RobotMap.rightEncoder
				.getRate()) / 2;
	}

	public double getMeanEncoderDistance() {
		return (RobotMap.leftEncoder.getDistance() + RobotMap.rightEncoder
				.getDistance()) / 2;
	}
	
	public double getGyroHeading(){
		return RobotMap.gyro.getAngle();
	}

	public void tankDrive(double leftSpeed, double rightSpeed) {
		RobotMap.drivetrain.tankDrive(leftSpeed, rightSpeed);

	}

	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		RobotMap.drivetrain.arcadeDrive(moveSpeed, rotateSpeed);

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ArcadeDriveWithSticks());
	}
}
