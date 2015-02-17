package org.usfirst.frc.team2175.robot;

/**
 * This class handles ramping of values over time to allow for smooth motor
 * control
 *
 * @author FRC 2175
 *
 */
public class Ramp {
    // Right now, this only ramps the values given to it, so it may not work for
    // PID, but we'll try it.

    private double output, prevTime, maxOutputDelta;

    /**
     * Makes a new ramp
     *
     * @param maxOutputDelta
     *            Output delta to limit the value to. Larger values make the
     *            robot less responsive
     */
    public Ramp(double maxOutputDelta) {
        this.maxOutputDelta = maxOutputDelta;
    }

    public void init(double input) {
        prevTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        output = input;
    }

    // FIXME see if this is used
    public void init() {
        this.init(0);
    }

    // FIXME there's a bug in here somewhere where error accumulates over time
    // and leads to complete loss of control
    public double rampInput(double input) {
        // compute time difference
        double newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        double deltaTime = newTime - prevTime;

        // check both bounds and coerce
        if (input > output + maxOutputDelta * deltaTime) {
            output += maxOutputDelta * deltaTime;
        } else if (input < output - maxOutputDelta * deltaTime) {
            output -= maxOutputDelta * deltaTime;
        } else {
            output = input;
        }

        prevTime = newTime; // set new prevTime

        return output;
    }

}
