package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	public static Talon toteElevatorTalon = new Talon(0);
	public static DigitalInput topSwitch = new DigitalInput(0);
	public static DigitalInput bottomSwitch = new DigitalInput(1);
	public static Encoder elevatorEncoder = new Encoder(1,2,false,EncodingType.k2X);
	public static Encoder containerElevatorEncoder = new Encoder(3,4,false,EncodingType.k2X);
	public static Talon containerElevatorMotor = new Talon(1);
	public static DigitalInput containerTopSwitch = new DigitalInput(3);
	public static DigitalInput containerBottomSwitch = new DigitalInput(4);
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
