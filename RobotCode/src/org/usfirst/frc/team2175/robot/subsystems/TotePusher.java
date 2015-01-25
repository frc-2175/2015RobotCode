package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class TotePusher extends Subsystem{
    
	public void setMotorSpeed(double armspeed){
		RobotMap.totePusherArm.set(armspeed);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
    
}

