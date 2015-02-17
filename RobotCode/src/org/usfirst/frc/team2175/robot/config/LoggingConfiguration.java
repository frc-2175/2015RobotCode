package org.usfirst.frc.team2175.robot.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class LoggingConfiguration {
    /** Use ROBOT_LOCATION for deployment running. */
    public static final String LOGGING_PROPERTIES_FILE_ROBOT_LOCATION = "/home/lvuser/logging.properties";

    /** Use ACTUAL_LOCATION for tests. */
    public static final String LOGGING_PROPERTIES_FILE_ACTUAL_LOCATION = "src/logging.properties";

    private String loggingPropertiesFileToUse = LOGGING_PROPERTIES_FILE_ROBOT_LOCATION;

    public void initializeLogging() {
        initializeFileLog();
    }

    protected void initializeFileLog() {
        final LogManager logManager = LogManager.getLogManager();

        InputStream in;
        try {
            in = new FileInputStream(loggingPropertiesFileToUse);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(
                    "Did not find logging properties file="
                            + loggingPropertiesFileToUse + ", msg="
                            + e.getMessage(), e);
        }

        try {
            logManager.readConfiguration(in);
        } catch (SecurityException | IOException e) {
            throw new IllegalStateException(
                    "Unable to read logging properties", e);
        }
    }

    public String getLoggingPropertiesFileToUse() {
        return loggingPropertiesFileToUse;
    }

    public void setLoggingPropertiesFileToUse(String loggingPropertiesFileToUse) {
        this.loggingPropertiesFileToUse = loggingPropertiesFileToUse;
    }
}
