package org.usfirst.frc.team2175.robot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RobotConfig {

	private double deadbandSize;
	
	//add more properties here

	public RobotConfig() throws IOException {
		Properties prop = new Properties();
		String propFileName = "/home/lvuser/robot.properties";

		InputStream inputStream = new FileInputStream(propFileName);

		prop.load(inputStream);

		if (prop.isEmpty()) {
			throw new IllegalStateException("No properties were loaded");
		}

		deadbandSize = Double.parseDouble(prop.getProperty("deadbandSize"));
	}

	public double getDeadbandSize() {
		return deadbandSize;
	}
}