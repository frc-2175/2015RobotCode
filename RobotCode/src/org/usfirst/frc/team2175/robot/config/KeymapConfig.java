package org.usfirst.frc.team2175.robot.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeymapConfig extends AbstractConfig {
    final Logger log = Logger.getLogger(getClass().getName());

    private static final String PROPERTY_FILE_NAME = "/home/lvuser/keymap.properties";

    private final int openContainerIntake;
    private final int closeContainerIntake;
    private final int openToteIntake;
    private final int closeToteIntake;
    private final int runToteIntakeWheels;
    private final int runToteIntakeWheelsBackwards;
    private final int moveToteElevatorManually;
    private final int moveContainerElevatorManually;
    private final int pushToteOut;

    public KeymapConfig() {
        try {
            Properties prop = new PropertiesLoader()
                    .loadProperties(PROPERTY_FILE_NAME);

            openContainerIntake = getIntPropertyValue("openContainerIntake",
                    prop);
            closeContainerIntake = getIntPropertyValue("closeContainerIntake",
                    prop);
            openToteIntake = getIntPropertyValue("openToteIntake", prop);
            closeToteIntake = getIntPropertyValue("closeToteIntake", prop);
            runToteIntakeWheels = getIntPropertyValue("runToteIntakeWheels",
                    prop);
            runToteIntakeWheelsBackwards = getIntPropertyValue(
                    "runToteIntakeWheelsBackwards", prop);
            moveToteElevatorManually = getIntPropertyValue(
                    "moveToteElevatorManually", prop);
            moveContainerElevatorManually = getIntPropertyValue(
                    "moveContainerElevatorManually", prop);
            pushToteOut = getIntPropertyValue("pushOutTote", prop);

        } catch (Exception e) {
            final String msg = "Problem with processing Keymap, can't continue:";
            log.log(Level.SEVERE, msg, e);
            throw e;
        }
    }

    public int getOpenContainerIntake() {
        return openContainerIntake;
    }

    public int getCloseContainerIntake() {
        return closeContainerIntake;
    }

    public int getOpenToteIntake() {
        return openToteIntake;
    }

    public int getCloseToteIntake() {
        return closeToteIntake;
    }

    public int getRunToteIntakeWheels() {
        return runToteIntakeWheels;
    }

    public int getRunToteIntakeWheelsBackwards() {
        return runToteIntakeWheelsBackwards;
    }

    public int getMoveToteElevatorManually() {
        return moveToteElevatorManually;
    }

    public int getMoveContainerElevatorManually() {
        return moveContainerElevatorManually;
    }

    public int getPushToteOut() {
        return pushToteOut;
    }

}
