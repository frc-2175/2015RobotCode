package org.usfirst.frc.team2175.robot;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class LoggingConfiguration {
    private static final String LOGGING_PROPERTIES_FILE = "/logging.properties";

    protected void initializeLogging() {
        final LogManager logManager = LogManager.getLogManager();

        final InputStream in = getClass().getResourceAsStream(
                LOGGING_PROPERTIES_FILE);
        if (in == null) {
            throw new IllegalStateException(
                    "Did not find logging properties file="
                            + LOGGING_PROPERTIES_FILE);
        }

        try {
            logManager.readConfiguration(in);
        } catch (SecurityException | IOException e) {
            throw new IllegalStateException(
                    "Unable to read logging properties", e);
        }
    }
}
