package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.subsystems.ExamplePIDSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExamplePIDCommand extends Command {

	double setpoint;
	ExamplePIDSubsystem subsystem = null;

	public ExamplePIDCommand(double setpoint) {
		// Save the setpoint to an instance variable
		this.setpoint = setpoint;
	}

	protected void initialize() {
		// Set the new PID setpoint
		subsystem.controller.setSetpoint(setpoint);
		// Enable the controller
		subsystem.controller.enable();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		// Stop if we are close enough to our setpoint
		return subsystem.controller.onTarget();
	}

	protected void end() {
		// Disable the controller once we are done running this command
		subsystem.controller.disable();
	}

	protected void interrupted() {
		// Make sure to run end when interrupted! Otherwise the PID stuff will
		// keep running EVEN AFTER THE COMMAND IS FINISHED.
		end();
	}
}
