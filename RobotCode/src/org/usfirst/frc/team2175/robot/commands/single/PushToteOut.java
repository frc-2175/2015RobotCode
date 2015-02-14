package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Scheduler;

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
        if (!Robot.toteIntake.isIntakeArmsOut()) {
            Robot.toteIntake.setIntakeArms(true);
        }
        Robot.toteIntake.setPusherSpeed(Robot.properties.getTotePusherSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        MoveTotePusherIn command = new MoveTotePusherIn();
        Scheduler.getInstance().add(command);
    }

    @Override
    protected void interrupted() {
        end();
    }
}