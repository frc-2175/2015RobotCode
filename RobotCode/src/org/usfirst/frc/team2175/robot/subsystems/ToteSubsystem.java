package org.usfirst.frc.team2175.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ToteSubsystem extends Subsystem{
	
	public ToteElevator elevator;
	
	public ToteSubsystem(){
		elevator = new ToteElevator();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
