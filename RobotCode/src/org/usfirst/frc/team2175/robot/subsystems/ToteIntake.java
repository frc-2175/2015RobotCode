package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;


/**
 *
 */
public class ToteIntake {
	
	public void setWheelSpeed(double wheelSpeed) {
		RobotMap.intakeWheelMotor.set(wheelSpeed);
	}
	
	public void setIntakeArms(boolean in){
		RobotMap.intakeArms.set(in);
	}
	
}
