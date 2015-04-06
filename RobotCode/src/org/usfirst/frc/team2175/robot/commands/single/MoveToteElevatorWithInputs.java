package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class MoveToteElevatorWithInputs extends CommandBase {

    private double input;

    public MoveToteElevatorWithInputs(double input) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.toteElevator);
        this.input = input;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
        Robot.toteElevator.toteElevatorController.disable();

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.toteElevator.setToteElevatorSpeed(-input);
        Robot.toteElevator.updateBrakeSetting();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (Robot.toteElevator.isAtTop()
                && Robot.toteElevator.getMotorOutput() > 0) {
            return true;
        } else if (Robot.toteElevator.isAtBottom()
                && Robot.toteElevator.getMotorOutput() < 0) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.toteElevator.setToteElevatorSpeed(0);
        Robot.toteElevator.updateBrakeSetting();
        super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
