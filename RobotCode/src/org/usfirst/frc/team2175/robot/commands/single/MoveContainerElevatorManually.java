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
        // if (Robot.oi.gamepad.getRawButton(10) == true) {
        double elevatorSpeed = Robot.oi.gamepad.getY();
        Robot.containerElevator.setContainerElevatorSpeed(elevatorSpeed);
        // }
        if (Math.abs(Robot.containerElevator.getMotorOutput) < 0.05) {
            new EngageContainerLiftBrake();
        } else {
            new DisengageContainerLiftBrake();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.containerElevator.containerElevatorController.enable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
