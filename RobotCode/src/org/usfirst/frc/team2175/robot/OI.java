package org.usfirst.frc.team2175.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.CloseToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.MoveTotePusherIn;
import org.usfirst.frc.team2175.robot.commands.single.OpenContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.OpenToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.PushToteOut;
import org.usfirst.frc.team2175.robot.commands.single.ReleaseContainerIntakeArms;
import org.usfirst.frc.team2175.robot.commands.single.RunLeftToteIntakeWheels;
import org.usfirst.frc.team2175.robot.commands.single.RunLeftToteIntakeWheelsBackwards;
import org.usfirst.frc.team2175.robot.commands.single.RunRightToteIntakeWheels;
import org.usfirst.frc.team2175.robot.commands.single.RunRightToteIntakeWheelsBackwards;
import org.usfirst.frc.team2175.robot.commands.single.StopPusher;
import org.usfirst.frc.team2175.robot.commands.single.StowContainerIntakeArms;

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
    public JoystickButton toteMode;
    POVButton povUp;

    public double deadbandValue;
    public double gamepadDeadbandValue;

    public OI() {
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        gamepad = new Joystick(2);

        precisionMode = new JoystickButton(rightStick, 1);
        toteMode = new JoystickButton(leftStick, 1);

        deadbandValue = Robot.properties.getDeadbandSize();
        gamepadDeadbandValue = Robot.properties.getGamepadDeadbandSize();

        POVButton povUp = new POVButton(gamepad, POVButton.POVDirection.UP);
        JoystickButton runRightToteIntakeWheels = new JoystickButton(
                rightStick, Robot.keymap.getRunRightToteIntakeWheels());
        JoystickButton runRightToteIntakeWheelsBackwards = new JoystickButton(
                rightStick, Robot.keymap.getRunRightToteIntakeWheelsBackwards());
        JoystickButton runLeftToteIntakeWheels = new JoystickButton(leftStick,
                Robot.keymap.getRunLeftToteIntakeWheels());
        JoystickButton runLeftToteIntakeWheelsBackwards = new JoystickButton(
                leftStick, Robot.keymap.getRunLeftToteIntakeWheelsBackwards());
        JoystickButton closeContainerIntake = new JoystickButton(gamepad,
                Robot.keymap.getCloseContainerIntake());
        JoystickButton openContainerIntake = new JoystickButton(gamepad,
                Robot.keymap.getOpenContainerIntake());
        JoystickButton openToteIntake = new JoystickButton(rightStick,
                Robot.keymap.getOpenToteIntake());
        JoystickButton closeToteIntake = new JoystickButton(rightStick,
                Robot.keymap.getCloseToteIntake());
        JoystickButton pushToteOut = new JoystickButton(gamepad,
                Robot.keymap.getPushToteOut());
        JoystickButton pushToteIn = new JoystickButton(gamepad,
                Robot.keymap.getMoveToteElevatorManually());
        JoystickButton stowContainerIntake = new JoystickButton(gamepad,
                Robot.keymap.getStowContainerIntake());
        JoystickButton releaseContainerIntake = new JoystickButton(gamepad,
                Robot.keymap.getReleaseContainerIntake());

        runRightToteIntakeWheels.whileHeld(new RunRightToteIntakeWheels());
        runRightToteIntakeWheelsBackwards
                .whileHeld(new RunRightToteIntakeWheelsBackwards());
        runLeftToteIntakeWheels.whileHeld(new RunLeftToteIntakeWheels());
        runLeftToteIntakeWheelsBackwards
                .whileHeld(new RunLeftToteIntakeWheelsBackwards());
        closeContainerIntake.whenPressed(new CloseContainerIntake());
        openContainerIntake.whenPressed(new OpenContainerIntake());
        openToteIntake.whenPressed(new OpenToteIntake());
        closeToteIntake.whenPressed(new CloseToteIntake());

        pushToteIn.whenPressed(new MoveTotePusherIn());
        pushToteIn.whenReleased(new StopPusher());

        pushToteOut.whenPressed(new PushToteOut());
        pushToteOut.whenReleased(new StopPusher());

        stowContainerIntake.whenPressed(new StowContainerIntakeArms());
        releaseContainerIntake.whenPressed(new ReleaseContainerIntakeArms());

    }

    /**
     * Gets the move value for arcade drive. The direction considered "forward"
     * is defined in robot.properties.
     *
     * @return The arcade drive move value.
     */
    public double getMoveValue() {
        if (Robot.keymap.getIsContainerElevatorForward()) {
            return (getModifiedDriveValue("Move via leftstick Y value",
                    leftStick.getY()));
        } else {
            return (getModifiedDriveValue("Move via leftstick Y value",
                    -leftStick.getY()));
        }
    }

    /**
     * Gets the move value from the right stick, for tank drive.
     *
     * @return The move value for the right stick.
     */
    public double getMoveValueRight() {
        return (getModifiedDriveValue("Move via rightstick Y value",
                rightStick.getY()));
    }

    /**
     * Gets the turn value for arcade drive.
     *
     * @return The turn value for arcade drive.
     */
    public double getTurnValue() {
        return -rightStick.getX();
    }

    /**
     * Gets the container elevator speed from the gamepad. Only used for manual
     * control.
     *
     * @return The manual container elevator speed.
     */
    public double getContainerElevatorSpeed() {
        return handleGamepadDeadband(-gamepad.getY());
    }

    /**
     * Gets the tote elevator speed from the gamepad. Only used for manual
     * control.
     *
     * @return The manual tote elevator speed.
     */
    public double getToteElevatorSpeed() {
        return handleGamepadDeadband(-gamepad.getRawAxis(3));
    }

    /**
     * Modifies the drive values according to deadband, precision mode and
     * (someday) drivetrain ramping.
     *
     * @param name
     *            A descriptive name for this change, used in logging.
     * @param value
     *            The input value to modify (usually from a joystick.)
     * @return The new drivetrain output value, modified to account for
     *         deadband, precision mode and (someday) ramping.
     */
    protected double getModifiedDriveValue(String name, double value) {
        value = handleJoystickDeadband(value);

        double multiplier = determinePrecisionMultipler();

        double moveValue = value * multiplier;

        log.fine("change name=" + name + ", value=" + value + ", multiplier="
                + multiplier + ", resulting moveValue=" + moveValue);

        if (toteMode.get()) {
            return Robot.drivetrainRamp.rampInput(moveValue);
        } else {
            return (moveValue);
        }
    }

    /**
     * Gets the current precision mode multiplier value, based on the button
     * called precisionMode.
     *
     * @return The multiplier for precision mode, from 0 to 1.
     */
    protected double determinePrecisionMultipler() {
        final boolean isPrecisionMode = precisionMode.get();
        final double multiplier;
        if (isPrecisionMode) {
            multiplier = Robot.properties.getPrecisionModeScale();
        } else {
            multiplier = 1;
        }

        log.fine("isPrecisionMode=" + isPrecisionMode + ", multiplier="
                + multiplier);
        return multiplier;
    }

    /**
     * Gets a deadbanded version of the input value, assumed to come from a
     * joystick axis. The deadband threshold is defined in robot.properties.
     *
     * @param joystickInput
     *            The input value to which to apply deadband.
     * @return The deadbanded version of the input value.
     */
    protected double handleJoystickDeadband(double joystickInput) {
        double value;
        if (Math.abs(joystickInput) <= deadbandValue) {
            value = 0;
        } else {
            value = joystickInput;
        }

        log.fine("input=" + joystickInput + ", deadbandValue=" + deadbandValue
                + ", resulting value=" + value);
        return value;
    }

    /**
     * Gets a deadbanded version of the input value, assumed to come from a
     * gamepad thumbstick. The deadband threshold is defined in
     * robot.properties.
     *
     * @param gamepadInput
     *            The input value to which to apply deadband.
     * @return The deadbanded version of the input value.
     */
    protected double handleGamepadDeadband(double gamepadInput) {
        double outputValue;
        if (Math.abs(gamepadInput) <= gamepadDeadbandValue) {
            outputValue = 0;
        } else {
            outputValue = gamepadInput;
        }

        return outputValue;
    }
}
