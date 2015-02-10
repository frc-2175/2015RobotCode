package org.usfirst.frc.team2175.robot;

public class Ramp {
	// Right now, this only ramps the values given to it, so it may not work for
	// PID, but we'll try it.

	private double output, prevTime, maxDelta;

	public Ramp(double maxDelta) {
		this.maxDelta = maxDelta;
	}

	public void init(double input) {
		prevTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
		output = input;
	}

	public void init() {
		this.init(0);
	}

	public double RampInput(double input) {
		// compute time difference
		double newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
		double deltaTime = newTime - prevTime;

		// check both bounds and coerce
		if (input > output + maxDelta * deltaTime) {
			output += maxDelta * deltaTime;
		} else if (input < output - maxDelta * deltaTime) {
			output -= maxDelta * deltaTime;
		} else {
			output = input;
		}

		prevTime = newTime; // set new prevTime

		return output;
	}

}
