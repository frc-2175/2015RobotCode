package org.usfirst.frc.team2175.robot.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class LoggingConfigurationTest {
    final LoggingConfiguration sut = new LoggingConfiguration();

    /**
     * Verifies can find and read the logging config properties file and
     * displays example logging output.
     */
    @Test
    public void testInitializeFileLog() {
        sut.setLoggingPropertiesFileToUse(LoggingConfiguration.LOGGING_PROPERTIES_FILE_ACTUAL_LOCATION);
        sut.initializeFileLog();

        Logger log = Logger.getLogger(getClass().getName());
        log.info("log a test msg");

        Exception e = new IllegalArgumentException("the exception msg");
        log.log(Level.SEVERE, "Exception msg", e);
    }

    @Test
    public void testInitializeSocketLog() {
        sut.setLoggingPropertiesFileToUse(LoggingConfiguration.LOGGING_PROPERTIES_FILE_ACTUAL_LOCATION);
        sut.initializeSocketLog();
        Logger log = Logger.getLogger(getClass().getName());
        log.info("log a test msg");
    }

    @Test
    public void testInitializeLogging() {
        sut.setLoggingPropertiesFileToUse(LoggingConfiguration.LOGGING_PROPERTIES_FILE_ACTUAL_LOCATION);
        sut.initializeLogging();

        Logger log = Logger.getLogger(getClass().getName());
        log.info("log a test msg");
    }
}
