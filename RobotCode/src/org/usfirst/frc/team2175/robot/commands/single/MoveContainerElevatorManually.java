package org.usfirst.frc.team2175.robot.commands.single;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveContainerElevatorManually extends Command {
    private final Logger log = Logger.getLogger(getClass().getName());

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

        updateBrakeSetting();
    }

    private void updateBrakeSetting() {
        double motorOutput = Robot.containerElevator.getMotorOutput();

        log.fine("motorOutput=" + motorOutput);

        if (Math.abs(motorOutput) < 0.05) {
            Robot.containerElevator.setBrake(true);
        } else {
            Robot.containerElevator.setBrake(false);
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
