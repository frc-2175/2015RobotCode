package org.usfirst.frc.team2175.robot.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeymapConfig extends AbstractConfig {
    final Logger log = Logger.getLogger(getClass().getName());

    private static final String PROPERTY_FILE_NAME = "/home/lvuser/keymap.properties";

    private final int openContainerIntake;
    private final int closeConatinerIntake;
    private final int openToteIntake;
    private final int closeToteIntake;

    public KeymapConfig() {
        try {
            Properties prop = new PropertiesLoader()
                    .loadProperties(PROPERTY_FILE_NAME);

            openContainerIntake = Integer.parseInt(getIntPropertyValue(
                    "openContainerIntake", prop));
            closeContainerIntake = Integer.parseInt(getIntPropertyValue(
                    "closeContainerIntake", prop));
            openToteIntake = Integer.parseInt(getPropertyValue(
                    "openToteIntake", prop));
            closeContainerIntake = Integer.parseInt(getIntPropertyValue(
                    "closeToteIntake", prop));

        } catch (Exception e) {
            final String msg = "Problem with processing Keymap, can't continue:";
            log.log(Level.SEVERE, msg, e);
            throw e;
        }
    }
}
