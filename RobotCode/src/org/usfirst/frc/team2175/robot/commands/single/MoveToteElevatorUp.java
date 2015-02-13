package org.usfirst.frc.team2175.robot.commands.single;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class MoveToteElevatorUp extends CommandBase {
    private final Logger log = Logger.getLogger(getClass().getName());

    public MoveToteElevatorUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.toteElevator);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        super.initialize();
        double currentLevel = Robot.toteElevator.getHeight();
        double newLevel = Robot.properties.toteConfig
                .getNextLevelUp(currentLevel);
        MoveToteElevatorToPosition command = new MoveToteElevatorToPosition(
                newLevel);
        Scheduler.getInstance().add(command);
        log.log(Level.FINE, "Moving tote elevator up to " + newLevel);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
