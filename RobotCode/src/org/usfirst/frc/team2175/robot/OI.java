package org.usfirst.frc.team2175.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.DisengageContainerLiftBrake;
import org.usfirst.frc.team2175.robot.commands.single.EngageContainerLiftBrake;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorManually;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorManually;
import org.usfirst.frc.team2175.robot.commands.single.OpenContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.RunToteIntakeWheels;
import org.usfirst.frc.team2175.robot.commands.single.RunToteIntakeWheelsBackwards;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    // // CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    // joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    // // TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    private final Logger log = Logger.getLogger(getClass().getName());

    public Joystick leftStick;
    public Joystick rightStick;
    public Joystick gamepad;
    public JoystickButton precisionMode;
    public JoystickButton shifters;

    public double deadbandValue;

    public OI() {
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        gamepad = new Joystick(2);

        precisionMode = new JoystickButton(rightStick, 1);
        shifters = new JoystickButton(leftStick, 1);
        deadbandValue = Robot.properties.getDeadbandSize();

        JoystickButton gamepad1 = new JoystickButton(gamepad, 1);
        JoystickButton gamepad2 = new JoystickButton(gamepad, 2);
        JoystickButton gamepad3 = new JoystickButton(gamepad, 3);
        JoystickButton gamepad4 = new JoystickButton(gamepad, 4);
        JoystickButton gamepad5 = new JoystickButton(gamepad, 5);
        JoystickButton gamepad6 = new JoystickButton(gamepad, 6);
        JoystickButton gamepad7 = new JoystickButton(gamepad, 9);
        JoystickButton gamepad8 = new JoystickButton(gamepad, 10);
        JoystickButton gamepad9 = new JoystickButton(gamepad, 7);
        JoystickButton gamepad10 = new JoystickButton(gamepad, 8);

        gamepad1.whileHeld(new RunToteIntakeWheels());
        gamepad2.whileHeld(new RunToteIntakeWheelsBackwards());
        gamepad5.whenPressed(new CloseContainerIntake());
        gamepad6.whenPressed(new OpenContainerIntake());
        gamepad7.whenPressed(new EngageContainerLiftBrake());
        gamepad8.whenPressed(new DisengageContainerLiftBrake());
        gamepad9.whileHeld(new MoveToteElevatorManually());
        gamepad10.whileHeld(new MoveContainerElevatorManually());

    }

    public double getMoveValue() {
        return getChangeValue("Move via leftstick Y value", leftStick.getY());
    }

    public double getMoveValueRight() {
        return getChangeValue("Move via rightstick Y value", rightStick.getY());
    }

    public double getTurnValue() {
        return getChangeValue("Turn via rightstick X value", -rightStick.getX());
    }

    public double getContainerElevatorSpeed() {
        return handleDeadband(-gamepad.getY());
    }

    public double getToteElevatorSpeed() {
        return handleDeadband(gamepad.getRawAxis(3));
    }

    protected double getChangeValue(String name, double position) {
        double multiplier = determinePrecisionMultipler();
        double ramp = Robot.properties.getDriveTrainRamp();

        double moveValue = position * multiplier * ramp;

        log.fine("change name=" + name + ", value=" + position
                + ", multiplier=" + multiplier + ", Drivetrain Ramp=" + ramp
                + ", resulting moveValue=" + moveValue);

        return moveValue;
    }

    protected double determinePrecisionMultipler() {
        final boolean isPrecisionMode = precisionMode.get();
        final double multiplier;
        if (isPrecisionMode) {
            multiplier = Robot.properties.getPrescisionModeScale();
        } else {
            multiplier = 1;
        }

        log.fine("isPrecisionMode=" + isPrecisionMode + ", multiplier="
                + multiplier);
        return multiplier;
    }

    protected double handleDeadband(double input) {
        double value;
        if (Math.abs(input) <= deadbandValue) {
            value = 0;
        } else {
            value = input;
        }

        log.fine("input=" + input + ", deadbandValue=" + deadbandValue
                + ", resulting value=" + value);
        return value;
    }
}
