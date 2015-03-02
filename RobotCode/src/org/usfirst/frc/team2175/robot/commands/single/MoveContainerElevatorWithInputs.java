package org.usfirst.frc.team2175.robot.commands.single;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

/**
 *
 */
public class MoveContainerElevatorWithInputs extends CommandBase {

    private double input;

    public MoveContainerElevatorWithInputs(double input) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.containerElevator);
        this.input = input;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
        Robot.containerElevator.containerElevatorController.disable();

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.containerElevator.setContainerElevatorSpeed(input);
        Robot.containerElevator.updateBrakeSetting();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.containerElevator.setContainerElevatorSpeed(0);
        Robot.containerElevator.updateBrakeSetting();
        super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
