package org.usfirst.frc.team2175.robot.commands.single;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class MoveContainerElevatorToPosition extends CommandBase {

    double setpoint;
    private final Logger log = Logger.getLogger(getClass().getName());

    public MoveContainerElevatorToPosition(double setpoint) {
        requires(Robot.containerElevator);
        this.setpoint = setpoint;
    }

    @Override
    protected void initialize() {
        Robot.containerElevator.containerElevatorController
                .setSetpoint(setpoint);
        Robot.containerElevator.containerElevatorController.enable();
        log.log(Level.FINE, "Moving container elevator to position " + setpoint);
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return Robot.containerElevator.containerElevatorController.onTarget();
    }

    @Override
    protected void end() {
        Robot.containerElevator.containerElevatorController.disable();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
