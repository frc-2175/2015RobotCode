package org.usfirst.frc.team2175.robot.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;
import java.util.logging.XMLFormatter;

public class LoggingConfiguration extends AbstractConfig {
    /** Use ROBOT_LOCATION for deployment running. */
    public static final String LOGGING_PROPERTIES_FILE_ROBOT_LOCATION = "/home/lvuser/logging.properties";

    /** Use ACTUAL_LOCATION for tests. */
    public static final String LOGGING_PROPERTIES_FILE_ACTUAL_LOCATION = "src/logging.properties";

    private String loggingPropertiesFileToUse = LOGGING_PROPERTIES_FILE_ROBOT_LOCATION;

    public void initializeLogging() {
        initializeFileLog();
        initializeSocketLog();
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

    protected void initializeSocketLog() {
        final Handler handler = makeSocketHandler();

        if (handler != null) {
            configureSocketHandler(handler);
        }
    }

    protected Handler makeSocketHandler() {
        final Properties props = new PropertiesLoader()
                .loadProperties(loggingPropertiesFileToUse);

        final String socketHandlerHostname = getStringPropertyValue(
                "socket.handler.hostname", props);
        final int socketHandlerPort = getIntPropertyValue(
                "socket.handler.port", props);

        Handler handler = null;
        try {
            handler = new SocketHandler(socketHandlerHostname,
                    socketHandlerPort);
        } catch (IOException e) {
            final Logger log = Logger.getLogger(getClass().getName());
            final String msg = "Lilith log viewer not running?"
                    + " Error instantiating SocketHandler with host="
                    + socketHandlerHostname + ", socketHandlerPort"
                    + socketHandlerPort + ", msg=" + e.getClass().getName()
                    + ": " + e.getMessage();
            log.info(msg);
        }
        return handler;
    }

    protected void configureSocketHandler(final Handler handler) {
        final String handlerEncoding = "UTF-8";
        try {
            handler.setEncoding(handlerEncoding);
        } catch (SecurityException | UnsupportedEncodingException e) {
            throw new IllegalStateException("Error setting handler encoding="
                    + handlerEncoding, e);
        }

        final Formatter socketHandlerFormatter = new XMLFormatter();
        handler.setFormatter(socketHandlerFormatter);

        final Logger rootLogger = Logger.getLogger("");
        rootLogger.addHandler(handler);
    }

    public String getLoggingPropertiesFileToUse() {
        return loggingPropertiesFileToUse;
    }

    public void setLoggingPropertiesFileToUse(String loggingPropertiesFileToUse) {
        this.loggingPropertiesFileToUse = loggingPropertiesFileToUse;
    }
}
