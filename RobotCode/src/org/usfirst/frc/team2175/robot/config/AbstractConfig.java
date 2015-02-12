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

    protected String getStringPropertyValue(String propertyName,
            Properties props) {
        final String value = props.getProperty(propertyName);
        if (value == null) {
            String msg = "Property '" + propertyName
                    + "' not found in property file";
            log.severe(msg);
            throw new IllegalStateException(msg);
        }
        return value;
    }

    protected double getDoublePropertyValue(String propertyName,
            Properties props) {
        final String propertyValue = getStringPropertyValue(propertyName, props);
        return Double.parseDouble(propertyValue);
    }

    protected int getIntPropertyValue(String propertyName, Properties props) {
        final String propertyValue = getStringPropertyValue(propertyName, props);
        int propertyinteger = Integer.parseInt(propertyValue);
        System.out.println(propertyName + "=" + propertyinteger);
        return propertyinteger;

    }
}
