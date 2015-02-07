package org.usfirst.frc.team2175.robot.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RobotConfig {
    final Logger log = Logger.getLogger(getClass().getName());

    private static final String PROPERTY_FILE_NAME = "/home/lvuser/robot.properties";
    private static final String CAN_T_CONTINUE_MSG = "; can't continue";

    private final double deadbandSize;
    private final double toteElevatorP;
    private final double toteElevatorI;
    private final double toteElevatorD;
    private final double containerElevatorP;
    private final double containerElevatorI;
    private final double containerElevatorD;
    private final double toteIntakeWheelsSpeed;

    // tote elevator properties
    public final ToteElevatorConfig toteConfig;

    // container elevator properties
    public final ContainerElevatorConfig containerConfig;

    public RobotConfig() {
        Properties prop = loadProperties();

        deadbandSize = Double
                .parseDouble(getPropertyValue("deadbandSize", prop));

        toteConfig = makeToteElevatorConfig(prop);

        toteElevatorP = Double.parseDouble(getPropertyValue("toteElevatorP",
                prop));
        toteElevatorI = Double.parseDouble(getPropertyValue("toteElevatorI",
                prop));
        toteElevatorD = Double.parseDouble(getPropertyValue("toteElevatorD",
                prop));

        containerConfig = makeContainerElevatorConfig(prop);

        containerElevatorP = Double.parseDouble(getPropertyValue(
                "containerElevatorP", prop));
        containerElevatorI = Double.parseDouble(getPropertyValue(
                "containerElevatorI", prop));
        containerElevatorD = Double.parseDouble(getPropertyValue(
                "containerElevatorD", prop));
        toteIntakeWheelsSpeed = Double.parseDouble(getPropertyValue(
                "toteIntakeWheelsSpeed", prop));

    }

    private Properties loadProperties() {
        InputStream inputStream = openPropertiesFile();
        Properties prop = loadPropertiesFromFile(inputStream);

        if (prop.isEmpty()) {
            final String msg = "No properties were loaded from file="
                    + PROPERTY_FILE_NAME + CAN_T_CONTINUE_MSG;
            throw new IllegalStateException(msg);
        }

        return prop;
    }

    private InputStream openPropertiesFile() {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(PROPERTY_FILE_NAME);
        } catch (FileNotFoundException e) {
            final String msg = "Error finding properties file="
                    + PROPERTY_FILE_NAME + CAN_T_CONTINUE_MSG;
            log.log(Level.SEVERE, msg, e);
            throw new IllegalStateException(msg, e);
        }
        return inputStream;
    }

    private Properties loadPropertiesFromFile(InputStream inputStream) {
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            final String msg = "Error reading properties file="
                    + PROPERTY_FILE_NAME + CAN_T_CONTINUE_MSG;
            log.log(Level.SEVERE, msg, e);
            throw new IllegalStateException(msg, e);
        }
        return prop;
    }

    private ContainerElevatorConfig makeContainerElevatorConfig(Properties prop) {
        double level0, level1, level2, level3, level4;

        level0 = Double.parseDouble(getPropertyValue("containerPickupHeight",
                prop));
        level1 = Double.parseDouble(getPropertyValue("containerDrivingHeight",
                prop));
        level2 = Double.parseDouble(getPropertyValue("containerScoringHeight",
                prop));
        level3 = Double.parseDouble(getPropertyValue("containerStepHeight",
                prop));
        level4 = Double.parseDouble(getPropertyValue("containerStackHeight",
                prop));

        return new ContainerElevatorConfig(level0, level1, level2, level3,
                level4);
    }

    private ToteElevatorConfig makeToteElevatorConfig(Properties prop) {
        double pickup, driving, scoring, step, stack;

        pickup = Double.parseDouble(getPropertyValue("totePickupHeight", prop));
        driving = Double
                .parseDouble(getPropertyValue("toteDrivingHeight", prop));
        scoring = Double
                .parseDouble(getPropertyValue("toteScoringHeight", prop));
        step = Double.parseDouble(getPropertyValue("toteStepHeight", prop));
        stack = Double.parseDouble(getPropertyValue("toteStackHeight", prop));

        return new ToteElevatorConfig(pickup, driving, scoring, step, stack);
    }

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

    public double getToteElevatorP() {
        return toteElevatorP;
    }

    public double getToteElevatorI() {
        return toteElevatorI;
    }

    public double getToteElevatorD() {
        return toteElevatorD;
    }

    public double getContainerElevatorP() {
        return containerElevatorP;
    }

    public double getContainerElevatorI() {
        return containerElevatorI;
    }

    public double getContainerElevatorD() {
        return containerElevatorD;
    }

    public double getDeadbandSize() {
        return deadbandSize;
    }

    public double getToteIntakeWheelsSpeed() {
        return toteIntakeWheelsSpeed;
    }
}
