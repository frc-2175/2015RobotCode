package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;


/**
 *
 */
public class TotePusher {
    
	public void setMotorSpeed(double armspeed){
		RobotMap.totePusherArm.set(armspeed);
	}
    
}

