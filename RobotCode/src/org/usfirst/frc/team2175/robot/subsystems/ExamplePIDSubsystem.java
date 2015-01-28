package org.usfirst.frc.team2175.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExamplePIDSubsystem extends Subsystem {
	
	private PIDController controller;
	
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
		ControllerHandler controllerHandler = new ControllerHandler();
		controller = new PIDController(0, 0, 0, controllerHandler, controllerHandler);
		controller.setOutputRange(-0.5, 0.5);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}

