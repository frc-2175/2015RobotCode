package org.usfirst.frc.team2175.robot.subsystems;

import com.sun.xml.internal.fastinfoset.Encoder;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class containerElevator extends Subsystem {
	private DigitalInput topSwitch;
	private DigitalInput bottomSwitch;
	private Talon elevatorMotor;
	private Encoder elevatorEncoder;

	public ContainerElevator() {
		topSwitch = new DigitalInput(3);
		bottomSwitch = new DigitalInput(4);
		
		elevatorMotor = new Talon(0);
		
		elevatorEncoder = new Encoder(3, 4, false, EncodingType.k4X);
		elevatorEncoder.setDistancePerPulse(0);
		elevatorEncoder.setReverseDirection(false);
		

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
