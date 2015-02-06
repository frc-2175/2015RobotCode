package org.usfirst.frc.team2175.robot.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RobotConfig {
    private double deadbandSize;
    private double toteElevatorP;
    private double toteElevatorI;
    private double toteElevatorD;
    private double containerElevatorP;
    private double containerElevatorI;
    private double containerElevatorD;

    // tote elevator properties
    public ToteElevatorConfig toteConfig;

    // container elevator properties
    public ContainerElevatorConfig containerConfig;

    public RobotConfig() throws IOException {
        Properties prop = new Properties();
        String propFileName = "/home/lvuser/robot.properties";

        InputStream inputStream = new FileInputStream(propFileName);

        prop.load(inputStream);

        if (prop.isEmpty()) {
            throw new IllegalStateException("No properties were loaded");
        }

        deadbandSize = Double.parseDouble(prop.getProperty("deadbandSize"));

        double pickup, driving, scoring, step, stack;

        pickup = Double.parseDouble(prop.getProperty("totePickupHeight"));
        driving = Double.parseDouble(prop.getProperty("toteDrivingHeight"));
        scoring = Double.parseDouble(prop.getProperty("toteScoringHeight"));
        step = Double.parseDouble(prop.getProperty("toteStepHeight"));
        stack = Double.parseDouble(prop.getProperty("toteStackHeight"));

        toteConfig = new ToteElevatorConfig(pickup, driving, scoring, step,
                stack);

        toteElevatorP = Double.parseDouble(prop.getProperty("toteElevatorP"));
        toteElevatorI = Double.parseDouble(prop.getProperty("toteElevatorI"));
        toteElevatorD = Double.parseDouble(prop.getProperty("toteElevatorD"));

        // container elevator

        double level0, level1, level2, level3, level4;

        level0 = Double.parseDouble(prop.getProperty("containerPickupHeight"));
        level1 = Double.parseDouble(prop.getProperty("containerDrivingHeight"));
        level2 = Double.parseDouble(prop.getProperty("containerScoringHeight"));
        level3 = Double.parseDouble(prop.getProperty("containerStepHeight"));
        level4 = Double.parseDouble(prop.getProperty("containerStackHeight"));

        containerConfig = new ContainerElevatorConfig(level0, level1, level2,
                level3, level4);

        containerElevatorP = Double.parseDouble(prop
                .getProperty("containerElevatorP"));
        containerElevatorI = Double.parseDouble(prop
                .getProperty("containerElevatorI"));
        containerElevatorD = Double.parseDouble(prop
                .getProperty("containerElevatorD"));
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
}
