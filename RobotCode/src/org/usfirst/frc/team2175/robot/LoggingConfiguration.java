package org.usfirst.frc.team2175.robot;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class LoggingConfiguration {
    /** Use ROBOT_LOCATION for deployment running. */
    public static final String LOGGING_PROPERTIES_FILE_ROBOT_LOCATION = "/home/lvuser/logging.properties";

    /** Use ACTUAL_LOCATION for tests. */
    public static final String LOGGING_PROPERTIES_FILE_ACTUAL_LOCATION = "/logging.properties";

    private String loggingPropertiesFileToUse = LOGGING_PROPERTIES_FILE_ROBOT_LOCATION;

    protected void initializeLogging() {
        final LogManager logManager = LogManager.getLogManager();

        final InputStream in = getClass().getResourceAsStream(
                loggingPropertiesFileToUse);
        if (in == null) {
            throw new IllegalStateException(
                    "Did not find logging properties file="
                            + loggingPropertiesFileToUse);
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
