package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveTotePusherIn extends Command {

    public MoveTotePusherIn() {
        requires(Robot.toteIntake);
        setTimeout(Robot.properties.getToteRetractionTimeout());
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.toteIntake.setPusherSpeed(-Robot.properties.getTotePusherSpeed());
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || Robot.toteIntake.isPusherRetracted();

    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
        end();
    }
}
