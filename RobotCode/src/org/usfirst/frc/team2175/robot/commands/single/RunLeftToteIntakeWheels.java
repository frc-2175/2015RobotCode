package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class RunLeftToteIntakeWheels extends CommandBase {

    public RunLeftToteIntakeWheels() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // requires(Robot.toteIntake);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
    }

    public void setWheelSpeed(double wheelSpeed) {
        RobotMap.toteIntakeWheelMotorLeft.set(-wheelSpeed);
        log.fine("Running tote wheel left at speed "
                + Robot.properties.getToteIntakeWheelsSpeed());
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        // After testing, we leanred that the wheels must run in reverse to
        // intake
        setWheelSpeed(-Robot.properties.getToteIntakeWheelsSpeed());

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
        Robot.toteIntake.setLeftWheelSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
