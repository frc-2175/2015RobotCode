package org.usfirst.frc.team2175.robot.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RobotConfig {

	private double deadbandSize;
	private double toteElevatorP;
	private double toteElevatorI;
	private double toteElevatorD;
	
	//tote elevator properties
	public ToteElevatorConfig toteConfig;
	
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
		
		double pickup, driving, scoring, step, stack;
		
		pickup = Double.parseDouble(prop.getProperty("totePickupHeight"));
		driving = Double.parseDouble(prop.getProperty("toteDrivingHeight"));
		scoring = Double.parseDouble(prop.getProperty("toteScoringHeight"));
		step = Double.parseDouble(prop.getProperty("toteStepHeight"));
		stack = Double.parseDouble(prop.getProperty("toteStackHeight"));
		
		toteConfig = new ToteElevatorConfig(pickup, driving, scoring, step, stack);
		
		toteElevatorP = Double.parseDouble(prop.getProperty("toteElevatorP"));
		toteElevatorI = Double.parseDouble(prop.getProperty("toteElevatorI"));
		toteElevatorD = Double.parseDouble(prop.getProperty("toteElevatorD"));
		
	}

	public double getToteElevatorP() {
		return toteElevatorP;
	}

	public double getToteElevatorI() {
		return toteElevatorI;
	}

	public double getToteElevatorD() {
		return toteElevatorD;
	}

	public double getDeadbandSize() {
		return deadbandSize;
	}

	
}