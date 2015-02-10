package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroContainerElevator extends Command {
	
	
    public ZeroContainerElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.containerElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.containerElevator.containerElevatorController.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.containerElevator.setContainerElevatorSpeed(-0.1);
    	Robot.containerElevator.updateBrakeSetting();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.containerElevator.containerElevatorIsAtBottom();
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.containerElevatorEncoder.reset();
    	Robot.containerElevator.setContainerElevatorSpeed(0);
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    
}
