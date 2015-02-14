package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class MoveTotePusherIn extends CommandBase {
    public MoveTotePusherIn() {
        requires(Robot.toteIntake);
        // setTimeout(Robot.properties.getToteRetractionTimeout());
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        Robot.toteIntake.setPusherSpeed(-Robot.properties.getTotePusherSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;

    }

    @Override
    protected void end() {
        super.end();
        Robot.toteIntake.setPusherSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
