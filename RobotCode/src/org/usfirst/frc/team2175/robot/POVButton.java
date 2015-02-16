package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * Defines a virtual button based on a joystick POV hat. Acts as a normal button
 * to the code, but is triggered by pushing the POV hat in a specific direction.
 *
 * @author Ben Visness
 *
 */
public class POVButton extends Button {

    private GenericHID joystick;
    private POVDirection direction;

    /**
     * Defines which direction on the POV hat will register as a button press.
     */
    public static enum POVDirection {
        UP(0), RIGHT(90), DOWN(180), LEFT(270);

        private int value;

        private POVDirection(int value) {
            this.value = value;
        }
    }

    /**
     * Creates a new POVButton.
     *
     * @param joystick
     *            The joystick to which the POV hat belongs.
     * @param direction
     *            Which direction on the hat will register as a button press.
     */
    public POVButton(GenericHID joystick, POVDirection direction) {
        this.joystick = joystick;
        this.direction = direction;
    }

    @Override
    public boolean get() {
        return joystick.getPOV() == direction.value;
    }

}
