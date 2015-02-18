package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroToteElevator extends Command {

    public ZeroToteElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
        Robot.toteElevator.setToteElevatorSpeed(-0.17);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.toteElevator.isAtBottom();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        RobotMap.toteElevatorEncoder.reset();
        Robot.toteElevator.setToteElevatorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
