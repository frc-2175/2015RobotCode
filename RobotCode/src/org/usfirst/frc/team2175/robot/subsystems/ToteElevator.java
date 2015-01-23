package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;

/**
 *
 */
public class ToteElevator {

	public ToteElevator() {
		RobotMap.elevatorEncoder.setDistancePerPulse(0); // set distance per pulse!
		RobotMap.elevatorEncoder.setReverseDirection(false);
		// Add other encoder-related initializations here if needed.
	}

	public boolean isAtBottom() {
		return RobotMap.bottomSwitch.get();
	}

	public boolean isAtTop() {
		return RobotMap.topSwitch.get();
	}

	public void setSpeed(double toteElevatorSpeed) {
		RobotMap.toteElevatorTalon.set(toteElevatorSpeed);
	}

	public void resetEncoder() {
		RobotMap.elevatorEncoder.reset();
	}

	public double getHeight() {
		return RobotMap.elevatorEncoder.getDistance();
	}
}
