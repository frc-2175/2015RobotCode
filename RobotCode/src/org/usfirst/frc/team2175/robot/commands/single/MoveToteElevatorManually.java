package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveToteElevatorManually extends Command {

    public MoveToteElevatorManually() {
        requires(Robot.toteElevator);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.toteElevator.toteElevatorController.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double elevatorSpeed = Robot.oi.getToteElevatorSpeed();
        Robot.toteElevator.setToteElevatorSpeed(elevatorSpeed);
        Robot.toteElevator.updateBrakeSetting();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
