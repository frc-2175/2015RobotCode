package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class MoveToteElevatorDown extends Command {

    public MoveToteElevatorDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.toteElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double currentLevel = Robot.toteElevator.getHeight();
    	double newLevel = Robot.properties.toteConfig.getNextLevelDown(currentLevel);
    	MoveToteElevatorToPosition command = new MoveToteElevatorToPosition(newLevel);
    	Scheduler.getInstance().add(command);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
