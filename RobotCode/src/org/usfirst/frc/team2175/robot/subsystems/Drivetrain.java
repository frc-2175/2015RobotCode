package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	public void resetEncoders() {
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
	}

	public double getMeanEncoderRate() {
		return (RobotMap.leftEncoder.getRate() + RobotMap.rightEncoder.getRate()) / 2;
	}

	public double getMeanEncoderDistance() {
		return (RobotMap.leftEncoder.getDistance() + RobotMap.rightEncoder.getDistance()) / 2;
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
	}
}
