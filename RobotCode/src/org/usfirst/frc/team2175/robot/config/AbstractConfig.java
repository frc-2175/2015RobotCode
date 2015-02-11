package org.usfirst.frc.team2175.robot.config;

import java.util.Properties;
import java.util.logging.Logger;

/**
 * Base class for loading properties.
 *
 * @author jjensen
 */
public abstract class AbstractConfig {
    private final Logger log = Logger.getLogger(getClass().getName());

    protected String getPropertyValue(String propertyName, Properties props) {
        String value = props.getProperty(propertyName);
        if (value == null) {
            String msg = "Property '" + propertyName
                    + "' not found in property file";
            log.severe(msg);
            throw new IllegalStateException(msg);
        }
        return value;
    }
}
