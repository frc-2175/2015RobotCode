package org.usfirst.frc.team2175.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExamplePIDSubsystem extends Subsystem {
	
	public PIDController controller;
	
	private class ControllerHandler implements PIDSource, PIDOutput {

		@Override
		public void pidWrite(double output) {
			// Do something with the output PID value, like update motors
		}

		@Override
		public double pidGet() {
			// Return the sensor value for the PID input
			return 0;
		}
		
	}
	
	public ExamplePIDSubsystem() {
		// Create the input/output handler for this controller
		ControllerHandler controllerHandler = new ControllerHandler();
		// Create the controller, setting the P, I, and D terms
		controller = new PIDController(0, 0, 0, controllerHandler, controllerHandler);
		// Set the tolerance (how far off the setpoint is considered "close enough")
		controller.setAbsoluteTolerance(0.5);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}

