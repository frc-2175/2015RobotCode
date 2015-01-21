package org.usfirst.frc.team2175.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private Talon leftTalon;
	private Talon rightTalon;
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	public Gyro gyro;
	private RobotDrive drivetrain;

	public Drivetrain() {
		drivetrain = new RobotDrive(1, 2, 3, 4);
		rightEncoder = new Encoder(1, 2, false,
				edu.wpi.first.wpilibj.CounterBase.EncodingType.k4X);
		leftEncoder = new Encoder(1, 2, false,
				edu.wpi.first.wpilibj.CounterBase.EncodingType.k4X);
		gyro = new Gyro(0);

	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public double getMeanEncoderRate() {
		return (leftEncoder.getRate() + rightEncoder.getRate()) / 2;
	}

	public double getMeanEncoderDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}

	

	public void tankDrive(double leftSpeed, double rightSpeed) {
		drivetrain.tankDrive(leftSpeed, rightSpeed);

	}

	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		drivetrain.arcadeDrive(moveSpeed, rotateSpeed);

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
