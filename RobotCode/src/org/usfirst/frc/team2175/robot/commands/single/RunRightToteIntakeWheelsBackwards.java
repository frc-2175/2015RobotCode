package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class RunRightToteIntakeWheelsBackwards extends CommandBase {

    public RunRightToteIntakeWheelsBackwards(int wheel) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.toteIntake);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        // After testing, the wheels must be set to forward to run outwards
        Robot.toteIntake.setRightWheelSpeed(Robot.properties
                .getToteIntakeWheelsSpeed());
        log.fine("Running tote wheel right backwards at speed "
                + Robot.properties.getToteIntakeWheelsSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        super.end();
        Robot.toteIntake.setRightWheelSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
