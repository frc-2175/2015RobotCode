package org.usfirst.frc.team2175.robot.config;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.usfirst.frc.team2175.robot.RobotMap;

public class PDPCurrentLogger {
	// Use Robot location for the actual robot and test location for the test
	public static final String CSV_OUT_ROBOT_LOCATION = "/home/lvuser/pdplog.csv";
	public static final String CSV_OUT_TEST_LOCATION = "build/testPDPlog.csv";

	private String logOutFileToUse = CSV_OUT_ROBOT_LOCATION;
	private OutputStreamWriter out;

	public void initPDPLogging() throws IOException {

		try {
			out = new FileWriter(logOutFileToUse);
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("pdp out file not found, msg = "
					+ e.getMessage(), e);
		}

		out.write("Starting new log... \n");
		out.write("Time, Port 0, Port 1, Port 2, Port 3, Port 4, Port 5, Port 6, Port 7, Port 8, Port 9, Port 10, Port 11, Port 12, Port 13, Port 14, Port 15 \n");

	}

	public void logPDPValues() throws IOException {
		// start with a timestamp
		out.write(edu.wpi.first.wpilibj.Timer.getFPGATimestamp() + ", ");
		// log the values
		for (int i = 0; i <= 15; i++) {
			out.write(RobotMap.pdp.getCurrent(i) + ", ");
		}
		// newline!
		out.write("\n");

	}
	
	public void endPDPLogging() throws IOException {
		out.write("Ending log. \n");
		out.close();
	}
	
	public void setLogOutFileToUse(String filepath) {
		logOutFileToUse = filepath;
	}
	
	public String getLogOutFileToUse() {
		return logOutFileToUse;
	}
	
}
