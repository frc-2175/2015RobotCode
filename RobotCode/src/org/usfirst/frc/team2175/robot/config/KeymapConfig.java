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
    private final int runRightToteIntakeWheels;
    private final int runRightToteIntakeWheelsBackwards;
    private final int runLeftToteIntakeWheels;
    private final int runLeftToteIntakeWheelsBackwards;
    private final int moveToteElevatorManually;
    private final int moveContainerElevatorManually;
    private final int pushToteOut;
    private final int stowContainerIntake;
    private final int releaseContainerIntake;
    private final int isContainerElevatorForward;
    private final int bringPusherIn;

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
            runRightToteIntakeWheels = getIntPropertyValue(
                    "runRightToteIntakeWheels", prop);
            runRightToteIntakeWheelsBackwards = getIntPropertyValue(
                    "runRightToteIntakeWheelsBackwards", prop);
            runLeftToteIntakeWheels = getIntPropertyValue(
                    "runLeftToteIntakeWheels", prop);
            runLeftToteIntakeWheelsBackwards = getIntPropertyValue(
                    "runLeftToteIntakeWheelsBackwards", prop);
            moveToteElevatorManually = getIntPropertyValue(
                    "moveToteElevatorManually", prop);
            moveContainerElevatorManually = getIntPropertyValue(
                    "moveContainerElevatorManually", prop);
            pushToteOut = getIntPropertyValue("pushToteOut", prop);
            stowContainerIntake = getIntPropertyValue("stowContainerIntake",
                    prop);
            releaseContainerIntake = getIntPropertyValue(
                    "releaseContainerIntake", prop);
            isContainerElevatorForward = getIntPropertyValue(
                    "isContainerElevatorForward", prop);
            bringPusherIn = getIntPropertyValue("bringPusherIn", prop);

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

    public int getRunRightToteIntakeWheels() {
        return runRightToteIntakeWheels;
    }

    public int getRunRightToteIntakeWheelsBackwards() {
        return runRightToteIntakeWheelsBackwards;
    }

    public int getRunLeftToteIntakeWheels() {
        return runLeftToteIntakeWheels;
    }

    public int getRunLeftToteIntakeWheelsBackwards() {
        return runLeftToteIntakeWheelsBackwards;
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

    public int getReleaseContainerIntake() {
        return releaseContainerIntake;
    }

    public int getStowContainerIntake() {
        return stowContainerIntake;
    }

    public int getBringPusherIn() {
        return bringPusherIn;
    }

    public boolean getIsContainerElevatorForward() {
        if (isContainerElevatorForward == 1) {
            return true;
        } else {
            return false;
        }
    }

}
