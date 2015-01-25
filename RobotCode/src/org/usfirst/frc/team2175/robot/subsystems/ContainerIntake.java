package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerIntake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setIntakeArms(boolean in){
		RobotMap.ContainerIntakeArms.set(in);
	}

    public void initDefaultCommand() {
    
    }
}

