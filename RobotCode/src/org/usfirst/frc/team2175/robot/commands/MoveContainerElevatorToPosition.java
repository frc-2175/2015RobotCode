package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveContainerElevatorToPosition extends CommandBase {
	
	double setpoint;

    public MoveContainerElevatorToPosition(double setpoint) {
    	requires(Robot.containerElevator);
    	this.setpoint = setpoint;
    }

    protected void initialize() {
    	Robot.containerElevator.containerElevatorController.setSetpoint(setpoint);
    	Robot.containerElevator.containerElevatorController.enable();
    }

    protected void execute() { //Does this have to start the motor?
    }

    protected boolean isFinished() {
        return Robot.containerElevator.containerElevatorController.onTarget();
    }

    protected void end() {
    	Robot.containerElevator.containerElevatorController.disable();
    }

    protected void interrupted() {
    	end();
    }
}
