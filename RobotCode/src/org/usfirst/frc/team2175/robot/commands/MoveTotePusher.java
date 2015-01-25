package org.usfirst.frc.team2175.robot.commands;

import org.usfirst.frc.team2175.robot.Robot;

/**
 *
 */
public class MoveTotePusher extends CommandBase {

	boolean commandingMoveOut;
	
    public MoveTotePusher(boolean commandingMoveOut) {
        requires(Robot.totePusher);
        this.commandingMoveOut=commandingMoveOut;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(commandingMoveOut){
    		Robot.totePusher.setMotorSpeed(.5);
    	}else{
    		Robot.totePusher.setMotorSpeed(-.5);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(commandingMoveOut){
        	return Robot.totePusher.isPusherExtended();
        }else{
        	return Robot.totePusher.isPusherRetracted();
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.totePusher.setMotorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
