package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class MoveTotePusher extends CommandBase {
    boolean commandingMoveOut;

    public MoveTotePusher(boolean commandingMoveOut) {
        requires(Robot.totePusher);
        this.commandingMoveOut = commandingMoveOut;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        // TODO propertize this
        if (commandingMoveOut) {
            Robot.totePusher.setMotorSpeed(Robot.properties
                    .getTotePusherSpeed());
        } else {
            Robot.totePusher.setMotorSpeed(-Robot.properties
                    .getTotePusherSpeed());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (commandingMoveOut) {
            return Robot.totePusher.isPusherExtended();
        } else {
            return Robot.totePusher.isPusherRetracted();
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        super.end();
        Robot.totePusher.setMotorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
