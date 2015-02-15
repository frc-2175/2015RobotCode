package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class POVButton extends Button {

    private GenericHID joystick;
    private POVDirection direction;

    public static enum POVDirection {
        UP(0), RIGHT(90), DOWN(180), LEFT(270);

        private int value;

        private POVDirection(int value) {
            this.value = value;
        }
    }

    public POVButton(GenericHID joystick, POVDirection direction) {
        this.joystick = joystick;
        this.direction = direction;
    }

    @Override
    public boolean get() {
        return joystick.getPOV() == direction.value;
    }

}
