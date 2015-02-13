package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class MoveToteElevatorToPosition extends CommandBase {
    private double setpoint;

    public MoveToteElevatorToPosition(double setpoint) {
        requires(Robot.toteElevator);
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
        log.info("Moving elevator to position " + setpoint);

        Robot.toteElevator.toteElevatorController.setSetpoint(setpoint);
        Robot.toteElevator.toteElevatorController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.toteElevator.toteElevatorController.onTarget();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        super.end();

        Robot.toteElevator.toteElevatorController.onTarget();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
