package org.usfirst.frc.team2175.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteElevator {
    
	private DigitalInput topSwitch; 
	private DigitalInput bottomSwitch;
	private Talon elevatorMotor;
	private Encoder elevatorEncoder;
	
	public ToteElevator(){
		topSwitch = new DigitalInput(0); //specify port later!
		bottomSwitch = new DigitalInput(1); //specify port later!
		
		elevatorEncoder = new Encoder(1, 2, false, EncodingType.k4X); //specify channel later!
		elevatorEncoder.setDistancePerPulse(0); //set distance per pulse! 
		elevatorEncoder.setReverseDirection(false);
		 //Add other encoder-related initializations here if needed. 
	}
	
	public boolean isAtBottom(){
		return bottomSwitch.get();
	}
	
	public boolean isAtTop(){
		return topSwitch.get();
	}
	
	public void setSpeed(double toteElevatorSpeed){
		elevatorMotor.set(toteElevatorSpeed);
	}
	
	public void resetEncoder(){
		elevatorEncoder.reset();
	}
	
	public double getHeight(){
		return elevatorEncoder.getDistance();
	}
}

