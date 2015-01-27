package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteElevator extends Subsystem{

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
		if(isAtTop()&&toteElevatorSpeed>0){
			RobotMap.toteElevatorTalon.set(0);
		} if(isAtBottom()&&toteElevatorSpeed<0){
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
