package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class TotePusher extends Subsystem{
    
	public void setMotorSpeed(double armspeed){
		if(isPusherExtended()&&armspeed>=0) {
			RobotMap.totePusherArm.set(0);
		} if(isPusherRetracted()&&armspeed<=0){
			RobotMap.totePusherArm.set(0);
		}else{
			RobotMap.totePusherArm.set(armspeed);
		}
	}
	
	public boolean isPusherExtended(){
		return RobotMap.pusherOutSwitch.get();
	}
	public boolean isPusherRetracted(){
		return RobotMap.pusherInSwitch.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
    
}

