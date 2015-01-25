package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class ToteIntake extends Subsystem{
	
	public void setWheelSpeed(double wheelSpeed) {
		RobotMap.intakeWheelMotor.set(wheelSpeed);
	}
	
	public void setIntakeArms(boolean in){
		RobotMap.intakeArms.set(in);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
