package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteElevator extends Subsystem {

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		RobotMap.toteElevatorTalon.set(output);
	}

	public PIDController heightController;

	private class HeightControllerHandler implements PIDSource, PIDOutput {

		@Override
		public void pidWrite(double output) {
			// Do something with the output PID value, like update motors
		}

		@Override
		public double pidGet() {
			// Return the sensor value for the PID input
			return 0;
		}
	}

	public void ToteElevator() {
		// TODO Find actual distance per pulse
		RobotMap.elevatorEncoder.setDistancePerPulse(0);
		RobotMap.elevatorEncoder.setReverseDirection(false);
		HeightControllerHandler heightHandler = new HeightControllerHandler();
		heightController = new PIDController(0, 0, 0, heightHandler,
				heightHandler);
		heightController.setAbsoluteTolerance(.05);
		// Add other encoder-related initializations here if needed.
	}

	public boolean isAtBottom() {
		return RobotMap.bottomSwitch.get();
	}

	public boolean isAtTop() {
		return RobotMap.topSwitch.get();
	}

	public void setSpeed(double toteElevatorSpeed) {
		if (isAtTop() && toteElevatorSpeed > 0) {
			RobotMap.toteElevatorTalon.set(0);
		} else if (isAtBottom() && toteElevatorSpeed < 0) {
			RobotMap.toteElevatorTalon.set(0);
		} else {
			RobotMap.toteElevatorTalon.set(toteElevatorSpeed);
		}
	}

	public void resetEncoder() {
		RobotMap.elevatorEncoder.reset();
	}

	public double getHeight() {
		return RobotMap.elevatorEncoder.getDistance();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}
