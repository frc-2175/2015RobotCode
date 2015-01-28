package org.usfirst.frc.team2175.robot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RobotConfig {

	private double deadbandSize;
	
	//tote elevator properties
	private double toteElevatorGroundPosition;
	private double toteElevatorStackPosition;
	
	//add more properties here

	public RobotConfig() throws IOException {
		Properties prop = new Properties();
		String propFileName = "/home/lvuser/robot.properties";

		InputStream inputStream = new FileInputStream(propFileName);

		prop.load(inputStream);

		if (prop.isEmpty()) {
			throw new IllegalStateException("No properties were loaded");
		}

		deadbandSize = Double.parseDouble(prop.getProperty("deadbandSize")); //TODO set values for constants in the properties file
		
		toteElevatorGroundPosition = Double.parseDouble(prop.getProperty("toteIntakeFloorPosition")); 
		toteElevatorStackPosition = Double.parseDouble(prop.getProperty("toteIntakeIntakePosition"));
	}

	public double getDeadbandSize() {
		return deadbandSize;
	}

	public double getToteElevatorGroundPosition() {
		return toteElevatorGroundPosition;
	}

	public double getToteElevatorStackPosition() {
		return toteElevatorStackPosition;
	}
}