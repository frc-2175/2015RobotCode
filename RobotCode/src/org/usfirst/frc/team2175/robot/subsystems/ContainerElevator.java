package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerElevator extends Subsystem {
	
	public ContainerElevator() {
		RobotMap.containerElevatorEncoder.setDistancePerPulse(0);
		RobotMap.containerElevatorEncoder.setReverseDirection(false);
	}

	public boolean containerIsAtTop(){
		return RobotMap.containerTopSwitch.get();
	}
	public boolean containerIsAtBottom(){
		return RobotMap.containerBottomSwitch.get();
	}
	public void setContainerSpeed(double containerSpeed){
		RobotMap.containerElevatorMotor.set(containerSpeed);
	}
	public double getContainerHeight(){
		return RobotMap.containerElevatorEncoder.get();
	}
	public void resetElevatorEncoder(){
		RobotMap.containerElevatorEncoder.reset();
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
