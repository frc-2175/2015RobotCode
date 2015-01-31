package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 * <p>
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * </p>
 * <p>
 * For example to map the left and right motors, you could define the following
 * variables to use with your drivetrain subsystem:
 * 
 * <pre>
 * public static int leftMotor = 1;
 * public static int rightMotor = 2;
 * </pre>
 * 
 * </p>
 * <p>
 * If you are using multiple modules, make sure to define both the port number
 * and the module. For example with a rangefinder:
 * 
 * <pre>
 * public static int rangefinderPort = 1;
 * public static int rangefinderModule = 1;
 * </pre>
 * 
 * </p>
 */
public class RobotMap {
	// drivetrain
	public static Talon leftTalon;
	public static Talon rightTalon;
	public static Encoder leftEncoder;
	public static Encoder rightEncoder;
	public static Gyro gyro;
	public static RobotDrive drivetrain;

	// tote elevator
	public static Talon toteElevatorTalon;
	public static DigitalInput topSwitch;
	public static DigitalInput bottomSwitch;
	public static Encoder elevatorEncoder; // TODO change these back from testing platform
								// values

	// container elevator
	public static DigitalInput containerTopSwitch;
	public static DigitalInput containerBottomSwitch;
	public static Talon containerElevatorMotor;
	public static Encoder containerElevatorEncoder;

	// tote intake
	public static Talon toteIntakeWheelMotor;
	public static Solenoid toteIntakeArms;
	public static DigitalInput toteIntakeToteInSwitch;

	// tote pusher
	public static Talon totePusherArm;

	public static DigitalInput pusherInSwitch;
	public static DigitalInput pusherOutSwitch;

	// container intake
	public static Solenoid ContainerIntakeArms;

	public static void init() {
		// drivetrain
		leftTalon = new Talon(10);
		rightTalon = new Talon(11);
//		leftEncoder = new Encoder(10, 11, false, EncodingType.k2X);
//		rightEncoder = new Encoder(12, 13, false, EncodingType.k2X);
		gyro = new Gyro(0);
		drivetrain = new RobotDrive(leftTalon, rightTalon);
		
		// tote elevator
		toteElevatorTalon = new Talon(0);
		topSwitch = new DigitalInput(14);
		bottomSwitch = new DigitalInput(15);
		elevatorEncoder = new Encoder(8, 9, false, EncodingType.k2X); // TODO change these back from testing platform values

		elevatorEncoder.reset();
		
		// container elevator
		containerTopSwitch = new DigitalInput(16);
		containerBottomSwitch = new DigitalInput(17);
		containerElevatorMotor = new Talon(13);
		containerElevatorEncoder = new Encoder(18, 19, false, EncodingType.k2X);

		// tote intake
		toteIntakeWheelMotor = new Talon(4);
		toteIntakeArms = new Solenoid(0);
		toteIntakeToteInSwitch = new DigitalInput(20);

		// tote pusher
		totePusherArm = new Talon(5);

		pusherInSwitch = new DigitalInput(21);
		pusherOutSwitch = new DigitalInput(22);

		// container intake
		ContainerIntakeArms = new Solenoid(1);
	}

}
