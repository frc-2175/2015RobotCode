package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
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
	
	public static final Talon leftTalon = new Talon(0);
	public static final Talon rightTalon = new Talon(0);
	public static final Encoder leftEncoder = new Encoder(0,0,false,EncodingType.k2X);
	public static final Encoder rightEncoder = new Encoder(0,0,false,EncodingType.k2X);;
	public static final Gyro gyro = new Gyro(0);
	public static RobotDrive drivetrain;

	public static final Talon toteElevatorTalon = new Talon(0);
	public static final DigitalInput topSwitch = new DigitalInput(0);
	public static final DigitalInput bottomSwitch = new DigitalInput(0);
	public static final Encoder elevatorEncoder = new Encoder(0,0,false,EncodingType.k2X);
	
	public static final DigitalInput containerTopSwitch = new DigitalInput(0);
	public static final DigitalInput containerBottomSwitch = new DigitalInput(0);
	public static final Talon containerElevatorMotor = new Talon(0);
	public static final Encoder containerElevatorEncoder = new Encoder(0,0,false,EncodingType.k2X); //Specify actual port numbers later.
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
