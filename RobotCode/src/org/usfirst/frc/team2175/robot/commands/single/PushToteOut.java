package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class PushToteOut extends CommandBase {

    public PushToteOut() {
        requires(Robot.toteIntake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.toteIntake.setPusherSpeed(Robot.properties.getTotePusherSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        // MoveTotePusherIn command = new MoveTotePusherIn();
        // Scheduler.getInstance().add(command);
        Robot.toteIntake.setPusherSpeed(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}