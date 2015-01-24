package org.usfirst.frc.team2175.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ToteSubsystem extends Subsystem{
	
	public ToteElevator elevator;
	public ToteIntake intake;
	public TotePusher pusher;
	
	public ToteSubsystem(){
		elevator = new ToteElevator();
		intake = new ToteIntake();
		pusher = new TotePusher();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
