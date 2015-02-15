package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class AxisButton extends Button {

    private static final double THRESHOLD = 0.9;

    private GenericHID joystick;
    private int axisNumber;
    private Direction direction;

    public enum Direction {
        POSITIVE, NEGATIVE
    }

    public AxisButton(GenericHID joystick, int axisNumber, Direction direction) {
        this.joystick = joystick;
        this.axisNumber = axisNumber;
        this.direction = direction;
    }

    @Override
    public boolean get() {
        if (direction == Direction.POSITIVE) {
            return joystick.getRawAxis(axisNumber) > THRESHOLD;
        } else {
            return joystick.getRawAxis(axisNumber) < -THRESHOLD;
        }
    }

}
