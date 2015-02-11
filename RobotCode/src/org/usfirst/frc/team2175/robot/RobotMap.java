package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
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
    public static DigitalInput toteSwitchTop;
    public static DigitalInput toteSwitchBottom;
    public static Encoder toteElevatorEncoder;

    // container elevator
    public static DigitalInput containerSwitchTop;
    public static DigitalInput containerSwitchBottom;
    public static Talon containerElevatorMotor;
    public static Encoder containerElevatorEncoder;
    public static DoubleSolenoid containerElevatorBrake;

    // tote intake
    public static Talon toteIntakeWheelMotor;
    public static DoubleSolenoid toteIntakeArms;
    public static DigitalInput toteIntakeToteInSwitch;
    public static DoubleSolenoid toteElevatorBrake;

    // tote pusher
    public static Talon totePusherArm;

    public static DigitalInput pusherSwitch;

    // container intake
    public static DoubleSolenoid containerIntakeArms;

    public static void init() {
        configurePowerDistributionPanel();
        configureDrivetrain();
        configureToteElevator();
        configureContainerElevator();
        configureToteIntake();
        configureTotePusher();
        configureContainerIntake();
    }

    private static void configurePowerDistributionPanel() {
        pdp = new PowerDistributionPanel();
    }

    private static void configureDrivetrain() {
        leftTalon = new Talon(0);
        rightTalon = new Talon(1);

        leftEncoder = new Encoder(19, 20, false, EncodingType.k2X);
        leftEncoder.setDistancePerPulse(Robot.properties
                .getDriveLeftEncoderDPP());

        rightEncoder = new Encoder(2, 3, false, EncodingType.k2X);
        rightEncoder.setDistancePerPulse(Robot.properties
                .getDriveRightEncoderDPP());

        // FIXME temp excluded so app can run
        // gyro = new Gyro(4);

        drivetrain = new RobotDrive(leftTalon, rightTalon);
    }

    private static void configureToteElevator() {
        // toteSwitchTop = new DigitalInput(4);
        // toteSwitchBottom = new DigitalInput(5);
        toteElevatorTalon = new Talon(2);
        toteSwitchTop = new DigitalInput(7);
        toteSwitchBottom = new DigitalInput(18);
        toteElevatorEncoder = new Encoder(5, 6, false, EncodingType.k2X);

        toteElevatorEncoder.reset();
        toteElevatorBrake = new DoubleSolenoid(6, 7);
    }

    private static void configureContainerElevator() {
        containerSwitchTop = new DigitalInput(1);
        containerSwitchBottom = new DigitalInput(0);
        containerElevatorMotor = new Talon(3);
        containerElevatorEncoder = new Encoder(8, 9, true, EncodingType.k2X);
        containerElevatorEncoder.setDistancePerPulse(1 / 120 * 12 * 5 / 25.4);
        containerElevatorEncoder.reset();
        containerElevatorBrake = new DoubleSolenoid(2, 3);
    }

    private static void configureToteIntake() {
        toteIntakeWheelMotor = new Talon(4);
        toteIntakeArms = new DoubleSolenoid(4, 5);
        toteIntakeToteInSwitch = new DigitalInput(11);
    }

    private static void configureTotePusher() {
        totePusherArm = new Talon(6);
        pusherSwitch = new DigitalInput(12);
    }

    private static void configureContainerIntake() {
        containerIntakeArms = new DoubleSolenoid(0, 1);
    }

    public static double getLeftTalonSpeed() {
        return leftTalon.get();
    }

    public static double getRightTalonSpeed() {
        return rightTalon.get();
    }

    public static double getLeftEncoderSpeed() {
        return rightEncoder.getRate();
    }

    public static double getRightEncoderSpeed() {
        return leftEncoder.getRate();
    }

    public static boolean getTopContainerLiftSwitch() {
        return containerSwitchTop.get();
    }

    public static boolean getBottomContainerLiftSwitch() {
        return containerSwitchBottom.get();
    }

    public static boolean getTopToteLiftSwitch() {
        return toteSwitchTop.get();
    }

    public static boolean getBottomToteLiftSwitch() {
        return toteSwitchBottom.get();
    }
}
