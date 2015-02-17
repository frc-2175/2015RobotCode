package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * Defines a virtual button based on a joystick axis. Acts as a normal button to
 * the code, but it is triggered by moving a joystick axis to an extreme in
 * either direction.
 *
 * @author FRC 2175
 *
 */
public class AxisButton extends Button {

    /**
     * The axis value must exceed this value to register as a button press.
     */
    private static final double THRESHOLD = 0.9;

    private GenericHID joystick;
    private int axisNumber;
    private AxisDirection direction;

    /**
     * Defines which direction on the axis will register as a button press.
     */
    public enum AxisDirection {
        POSITIVE, NEGATIVE
    }

    /**
     * Defines a new AxisButton.
     *
     * @param joystick
     *            The joystick to which the axis belongs.
     * @param axisNumber
     *            The number of the axis on the joystick.
     * @param direction
     *            Which direction on the axis will register as a button press.
     */
    public AxisButton(GenericHID joystick, int axisNumber,
            AxisDirection direction) {
        this.joystick = joystick;
        this.axisNumber = axisNumber;
        this.direction = direction;
    }

    @Override
    public boolean get() {
        if (direction == AxisDirection.POSITIVE) {
            return joystick.getRawAxis(axisNumber) > THRESHOLD;
        } else {
            return joystick.getRawAxis(axisNumber) < -THRESHOLD;
        }
    }

}
