package org.usfirst.frc.team2175.robot;

import java.util.Properties;

import org.usfirst.frc.team2175.robot.config.AbstractConfig;
import org.usfirst.frc.team2175.robot.config.PropertiesLoader;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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
public class RobotMap extends AbstractConfig {
    public static PowerDistributionPanel pdp;

    // drivetrain
    public static Talon leftTalon;
    public static Talon rightTalon;
    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    public static Gyro gyro;
    public static RobotDrive drivetrain;

    // tote elevator
    public static Talon toteElevatorMotor;
    public static DigitalInput toteSwitchTop;
    public static DigitalInput toteSwitchBottom;
    public static Encoder toteElevatorEncoder;
    public static Solenoid toteElevatorBrake;

    // container elevator
    public static DigitalInput containerSwitchTop;
    public static DigitalInput containerSwitchBottom;
    public static Talon containerElevatorMotor;
    public static Encoder containerElevatorEncoder;
    public static Solenoid containerElevatorBrake;

    // tote intake
    public static Talon toteIntakeWheelMotorRight;
    public static Talon toteIntakeWheelMotorLeft;
    public static DoubleSolenoid toteIntakeArms;
    public static DigitalInput toteIntakeToteInSwitch;
    public static Talon totePusher;
    public static DigitalInput pusherInSwitch;
    public static DigitalInput pusherOutSwitch;

    // container intake
    public static DoubleSolenoid containerIntakeArms;
    public static DoubleSolenoid containerSpatula;

    private static final String PROPERTY_FILE_NAME = "/home/lvuser/robotMap.properties";

    public void init() {
        Properties props = new PropertiesLoader()
                .loadProperties(PROPERTY_FILE_NAME);

        configurePowerDistributionPanel(props);
        configureDrivetrain(props);
        configureToteElevator(props);
        configureContainerElevator(props);
        configureToteIntake(props);
        configureTotePusher(props);
        configureContainerIntake(props);
    }

    private void configurePowerDistributionPanel(Properties props) {
        pdp = new PowerDistributionPanel();
    }

    private void configureDrivetrain(Properties props) {
        int leftTalonValue = getIntPropertyValue("drivetrain.talon.left", props);
        int rightTalonValue = getIntPropertyValue("drivetrain.talon.right",
                props);

        int leftEncoderAValue = getIntPropertyValue(
                "drivetrain.encoder.left.a", props);
        int leftEncoderBValue = getIntPropertyValue(
                "drivetrain.encoder.left.b", props);
        int rightEncoderAValue = getIntPropertyValue(
                "drivetrain.encoder.right.a", props);
        int rightEncoderBValue = getIntPropertyValue(
                "drivetrain.encoder.right.b", props);
        int gyroValue = getIntPropertyValue("drivetrain.gyro", props);

        leftTalon = new Talon(leftTalonValue);
        rightTalon = new Talon(rightTalonValue);

        leftEncoder = new Encoder(leftEncoderAValue, leftEncoderBValue, false,
                EncodingType.k2X);
        leftEncoder.setDistancePerPulse(Robot.properties
                .getDriveLeftEncoderDPP());

        rightEncoder = new Encoder(rightEncoderAValue, rightEncoderBValue,
                false, EncodingType.k2X);
        rightEncoder.setDistancePerPulse(Robot.properties
                .getDriveRightEncoderDPP());

        // FIXME temp excluded so app can run
        // gyro = new Gyro(gyroValue);

        drivetrain = new RobotDrive(leftTalon, rightTalon);
    }

    private void configureToteElevator(Properties props) {
        int motorValue = getIntPropertyValue("tote.elevator.motor", props);
        int switchTopValue = getIntPropertyValue("tote.elevator.switch.top",
                props);
        int switchBottomValue = getIntPropertyValue(
                "tote.elevator.switch.bottom", props);
        int encoderAValue = getIntPropertyValue("tote.elevator.encoder.a",
                props);
        int encoderBValue = getIntPropertyValue("tote.elevator.encoder.b",
                props);
        int brakeForwardValue = getIntPropertyValue("tote.elevator.brake",
                props);

        toteElevatorMotor = new Talon(motorValue);

        toteSwitchTop = new DigitalInput(switchTopValue);
        toteSwitchBottom = new DigitalInput(switchBottomValue);

        toteElevatorEncoder = new Encoder(encoderAValue, encoderBValue, false,
                EncodingType.k2X);
        toteElevatorEncoder.reset();

        toteElevatorBrake = new Solenoid(brakeForwardValue);
    }

    private void configureToteIntake(Properties props) {
        int rightMotorValue = getIntPropertyValue("tote.intake.motor.right",
                props);
        int leftMotorValue = getIntPropertyValue("tote.intake.motor.left",
                props);
        int armsForwardValue = getIntPropertyValue("tote.intake.arms.forward",
                props);
        int armsReverseValue = getIntPropertyValue("tote.intake.arms.reverse",
                props);
        int inSwitchValue = getIntPropertyValue("tote.intake.in.switch", props);

        toteIntakeWheelMotorRight = new Talon(rightMotorValue);
        toteIntakeWheelMotorLeft = new Talon(leftMotorValue);
        toteIntakeArms = new DoubleSolenoid(armsForwardValue, armsReverseValue);
        toteIntakeToteInSwitch = new DigitalInput(inSwitchValue);
    }

    private void configureTotePusher(Properties props) {
        int pusherArmValue = getIntPropertyValue("tote.pusher.arm", props);
        int pusherInSwitchValue = getIntPropertyValue("tote.pusher.in.switch",
                props);
        int pusherOutSwitchValue = getIntPropertyValue(
                "tote.pusher.out.switch", props);

        totePusher = new Talon(pusherArmValue);
        pusherInSwitch = new DigitalInput(pusherInSwitchValue);
        pusherOutSwitch = new DigitalInput(pusherOutSwitchValue);
    }

    private void configureContainerElevator(Properties props) {
        int switchTopValue = getIntPropertyValue(
                "container.elevator.switch.top", props);
        int switchBottomValue = getIntPropertyValue(
                "container.elevator.switch.bottom", props);
        int motorValue = getIntPropertyValue("container.elevator.motor", props);
        int encoderAValue = getIntPropertyValue("container.elevator.encoder.a",
                props);
        int encoderBValue = getIntPropertyValue("container.elevator.encoder.b",
                props);
        int brakeForwardValue = getIntPropertyValue("container.elevator.brake",
                props);

        containerSwitchTop = new DigitalInput(switchTopValue);
        containerSwitchBottom = new DigitalInput(switchBottomValue);
        containerElevatorMotor = new Talon(motorValue);
        containerElevatorEncoder = new Encoder(encoderAValue, encoderBValue,
                true, EncodingType.k2X);
        containerElevatorEncoder.setDistancePerPulse(1 / 120 * 12 * 5 / 25.4);
        containerElevatorEncoder.reset();
        containerElevatorBrake = new Solenoid(brakeForwardValue);
    }

    private void configureContainerIntake(Properties props) {
        int armsForwardValue = getIntPropertyValue(
                "container.intake.arms.forward", props);
        int armsReverseValue = getIntPropertyValue(
                "container.intake.arms.reverse", props);
        int spatulatForwardValue = getIntPropertyValue(
                "container.intake.spatula.forward", props);
        int spatulatReverseValue = getIntPropertyValue(
                "container.intake.spatula.reverse", props);

        containerIntakeArms = new DoubleSolenoid(armsForwardValue,
                armsReverseValue);
        containerSpatula = new DoubleSolenoid(spatulatForwardValue,
                spatulatReverseValue);
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

    public static double getToteElevatorEncoder() {
        return toteElevatorEncoder.getDistance();
    }
}
