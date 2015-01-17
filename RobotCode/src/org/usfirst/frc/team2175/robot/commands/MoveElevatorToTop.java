package org.usfirst.frc.team2175.robot.commands;

/**
 *
 */
public class MoveElevatorToTop extends CommandBase {

	private static final double toteElevatorSpeed = 0.5;
	
    public MoveElevatorToTop() {
        requires(toteSubsystem);
    }

    protected void initialize() {
    	toteSubsystem.elevator.setSpeed(toteElevatorSpeed);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return toteSubsystem.elevator.isAtTop();
    }

    protected void end() {
    	toteSubsystem.elevator.setSpeed(0);
    }

    protected void interrupted() {
    	end();
    }
}
