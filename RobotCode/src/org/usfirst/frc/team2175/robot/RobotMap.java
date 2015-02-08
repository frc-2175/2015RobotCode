package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
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
	public static PowerDistributionPanel pdp;
	
	// drivetrain
    public static Talon leftTalon;
    public static Talon rightTalon;
    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    public static Gyro gyro;
    public static RobotDrive drivetrain;

    // tote elevator
    public static Talon toteElevatorTalon;
    public static DigitalInput toteSwitch;
    public static Encoder toteElevatorEncoder;

    // container elevator
    public static DigitalInput containerSwitch;
    public static Talon containerElevatorMotor;
    public static Encoder containerElevatorEncoder;
    public static Solenoid containerElevatorBrake;

    // tote intake
    public static Talon toteIntakeWheelMotor;
    public static Solenoid toteIntakeArms;
    public static DigitalInput toteIntakeToteInSwitch;
    public static Solenoid toteElevatorBrake;

    // tote pusher
    public static Talon totePusherArm;

    public static DigitalInput pusherSwitch;
    // container intake
    public static Solenoid ContainerIntakeArms;

    public static void init() {
        pdp = new PowerDistributionPanel();
    	
    	// drivetrain
        leftTalon = new Talon(0);
        rightTalon = new Talon(1);
        // leftEncoder = new Encoder(0, 1, false, EncodingType.k2X);
        // rightEncoder = new Encoder(2, 3, false, EncodingType.k2X);
        // gyro = new Gyro(4);
        drivetrain = new RobotDrive(leftTalon, rightTalon);

        // tote elevator
        toteElevatorTalon = new Talon(2);
        toteSwitch = new DigitalInput(7);
        toteElevatorEncoder = new Encoder(5, 6, false, EncodingType.k2X); // TODO
                                                                          // change
                                                                          // these
                                                                          // back
                                                                          // from
                                                                          // testing
                                                                          // platform
                                                                          // values

        toteElevatorEncoder.reset();
        toteElevatorBrake = new Solenoid(2);
        

        // container elevator
        containerSwitch = new DigitalInput(10);
        containerElevatorMotor = new Talon(3);
        containerElevatorEncoder = new Encoder(8, 9, false, EncodingType.k2X);
        containerElevatorBrake = new Solenoid(3);

        // tote intake
        toteIntakeWheelMotor = new Talon(4);
        toteIntakeArms = new Solenoid(0);
        toteIntakeToteInSwitch = new DigitalInput(11);

        // tote pusher
        totePusherArm = new Talon(6);

        pusherSwitch = new DigitalInput(12);

        // container intake
        ContainerIntakeArms = new Solenoid(1);
    }

}
