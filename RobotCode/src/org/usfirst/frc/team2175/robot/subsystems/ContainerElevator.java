package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerElevator extends Subsystem {
	
	public PIDController containerElevatorController;
	
	private class ContainerElevatorControllerHandler implements PIDSource, PIDOutput {

		@Override
		public void pidWrite(double output) {
			RobotMap.containerElevatorMotor.set(output);
		}

		@Override
		public double pidGet() {
			return getContainerHeight(); 
		}
	}

    public ContainerElevator() {
    	ContainerElevatorControllerHandler containerElevatorControllerHandler = new ContainerElevatorControllerHandler();
    	containerElevatorController = new PIDController(0, 0, 0, containerElevatorControllerHandler, containerElevatorControllerHandler); 
    	//TODO determine PID constants
    	containerElevatorController.setAbsoluteTolerance(0.5);
    	
        RobotMap.containerElevatorEncoder.setDistancePerPulse(0); //TODO determine distance per pulse and direction of encoder
        RobotMap.containerElevatorEncoder.setReverseDirection(false);
    }

    public boolean containerElevatorIsAtTop(){
        return RobotMap.containerSwitch.get();
    }
    
    //TODO change these two to one sensor boolean
    
    public boolean containerElevatorIsAtBottom(){
        return RobotMap.containerSwitch.get();
    }
    
    public void setContainerElevatorSpeed(double containerSpeed){
    	if(containerElevatorIsAtTop() && RobotMap.containerElevatorMotor.getSpeed() > 0){
    		RobotMap.containerElevatorMotor.set(0);
    	}
    	else if(containerElevatorIsAtBottom() && RobotMap.containerElevatorMotor.getSpeed() < 0){
    		RobotMap.containerElevatorMotor.set(0);
    	}
    	else{
    		RobotMap.containerElevatorMotor.set(containerSpeed);
    	}
    }
    
    public double getContainerHeight(){
        return RobotMap.containerElevatorEncoder.getDistance();
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
