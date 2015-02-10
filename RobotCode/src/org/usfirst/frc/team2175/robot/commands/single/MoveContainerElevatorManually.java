package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveContainerElevatorManually extends Command {
    

    
    public MoveContainerElevatorManually() {
        requires(Robot.containerElevator);
        
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.containerElevator.containerElevatorController.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double elevatorSpeed = Robot.oi.getContainerElevatorSpeed();
        Robot.containerElevator.setContainerElevatorSpeed(elevatorSpeed);

        Robot.containerElevator.updateBrakeSetting();
    }

    

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.containerElevator.setContainerElevatorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
