package org.usfirst.frc.team2175.robot.subsystems;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDToteElevator extends PIDSubsystem {

	private DigitalInput toteTopSwitch = RobotMap.topSwitch;
	private DigitalInput toteBottomSwitch = RobotMap.bottomSwitch;
	private Talon toteElevatorTalon = RobotMap.toteElevatorTalon;
	private Encoder toteElevatorEncoder = RobotMap.elevatorEncoder;

    // Initialize your subsystem here
    public PIDToteElevator() {
    	super("PIDToteElevator",0,0,0); //TODO determine PID constants
    	
        setSetpoint(0);
        
    	// Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return toteElevatorEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	toteElevatorTalon.set(output);
    }
    
    public void setSetpoint(double setpoint) {
  
    }
}
