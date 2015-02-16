package org.usfirst.frc.team2175.robot.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RobotConfig extends AbstractConfig {
    final Logger log = Logger.getLogger(getClass().getName());

    private static final String PROPERTY_FILE_NAME = "/home/lvuser/robot.properties";

    // drivetrain properties
    private final double deadbandSize;
    private final double gamepadDeadbandSize;
    private final double precisionModeScale;
    private final double driveTrainRamp;
    private final double driveLeftEncoderDPP;
    private final double driveRightEncoderDPP;
    private final double drivetrainStraightDriveP;
    private final double drivetrainStraightDriveI;
    private final double drivetrainStraightDriveD;
    private final double drivetrainTurnDriveP;
    private final double drivetrainTurnDriveI;
    private final double drivetrainTurnDriveD;

    // tote intake properties
    private final double totePusherSpeed;
    private final double toteIntakeWheelsSpeed;
    private final double toteRetractionTimeout;

    // tote elevator properties
    public final ToteElevatorConfig toteConfig;
    private final double toteElevatorP;
    private final double toteElevatorI;
    private final double toteElevatorD;
    private final double toteElevatorEncoderDistancePerPulse;
    private final double toteElevatorBrakeThreshold;

    // container elevator properties
    public final ContainerElevatorConfig containerConfig;
    private final double containerElevatorP;
    private final double containerElevatorI;
    private final double containerElevatorD;
    private final double containerElevatorBrakeThreshold;

    public RobotConfig() {
        try {
            Properties prop = new PropertiesLoader()
                    .loadProperties(PROPERTY_FILE_NAME);

            deadbandSize = getDoublePropertyValue("deadbandSize", prop);
            gamepadDeadbandSize = getDoublePropertyValue("gamepadDeadbandSize",
                    prop);
            driveLeftEncoderDPP = getDoublePropertyValue("driveLeftEncoderDPP",
                    prop);
            driveRightEncoderDPP = getDoublePropertyValue(
                    "driveRightEncoderDPP", prop);
            drivetrainStraightDriveP = getDoublePropertyValue(
                    "drivetrainStraightDriveP", prop);
            drivetrainStraightDriveI = getDoublePropertyValue(
                    "drivetrainStraightDriveI", prop);
            drivetrainStraightDriveD = getDoublePropertyValue(
                    "drivetrainStraightDriveD", prop);
            drivetrainTurnDriveP = getDoublePropertyValue(
                    "drivetrainTurnDriveP", prop);
            drivetrainTurnDriveI = getDoublePropertyValue(
                    "drivetrainTurnDriveP", prop);
            drivetrainTurnDriveD = getDoublePropertyValue(
                    "drivetrainTurnDriveP", prop);

            toteConfig = makeToteElevatorConfig(prop);

            toteElevatorP = getDoublePropertyValue("toteElevatorP", prop);
            toteElevatorI = getDoublePropertyValue("toteElevatorI", prop);
            toteElevatorD = getDoublePropertyValue("toteElevatorD", prop);
            toteElevatorEncoderDistancePerPulse = getDoublePropertyValue(
                    "toteElevatorEncoderDistancePerPulse", prop);
            toteElevatorBrakeThreshold = getDoublePropertyValue(
                    "toteElevatorBrakeThreshold", prop);

            totePusherSpeed = getDoublePropertyValue("totePusherSpeed", prop);

            toteRetractionTimeout = getDoublePropertyValue(
                    "toteRetractionTimeout", prop);

            containerConfig = makeContainerElevatorConfig(prop);

            containerElevatorP = getDoublePropertyValue("containerElevatorP",
                    prop);
            containerElevatorI = getDoublePropertyValue("containerElevatorI",
                    prop);
            containerElevatorD = getDoublePropertyValue("containerElevatorD",
                    prop);
            containerElevatorBrakeThreshold = getDoublePropertyValue(
                    "containerElevatorBrakeThreshold", prop);
            toteIntakeWheelsSpeed = getDoublePropertyValue(
                    "toteIntakeWheelsSpeed", prop);
            precisionModeScale = getDoublePropertyValue("precisionModeScale",
                    prop);
            driveTrainRamp = getDoublePropertyValue("driveTrainRamp", prop);
        } catch (Exception e) {
            final String msg = "Problem with processing properties, can't continue:";
            log.log(Level.SEVERE, msg, e);
            throw e;
        }
    }

    public double getDrivetrainStraightDriveP() {
        return drivetrainStraightDriveP;
    }

    public double getDrivetrainStraightDriveI() {
        return drivetrainStraightDriveI;
    }

    public double getDrivetrainStraightDriveD() {
        return drivetrainStraightDriveD;
    }

    private ContainerElevatorConfig makeContainerElevatorConfig(Properties prop) {
        double downSpeed, maxDelta, level0, level1, level2, level3, level4;

        downSpeed = getDoublePropertyValue("containerElevatorDownSpeed", prop);

        maxDelta = getDoublePropertyValue("containerElevatorMaxDelta", prop);

        level0 = getDoublePropertyValue("containerPickupHeight", prop);
        level1 = getDoublePropertyValue("containerDrivingHeight", prop);
        level2 = getDoublePropertyValue("containerScoringHeight", prop);
        level3 = getDoublePropertyValue("containerStepHeight", prop);
        level4 = getDoublePropertyValue("containerStackHeight", prop);

        return new ContainerElevatorConfig(downSpeed, maxDelta, level0, level1,
                level2, level3, level4);
    }

    private ToteElevatorConfig makeToteElevatorConfig(Properties prop) {
        double maxDelta, pickup, driving, scoring, step, stack;

        maxDelta = getDoublePropertyValue("toteElevatorMaxDelta", prop);

        pickup = getDoublePropertyValue("totePickupHeight", prop);
        driving = getDoublePropertyValue("toteDrivingHeight", prop);
        scoring = getDoublePropertyValue("toteScoringHeight", prop);
        step = getDoublePropertyValue("toteStepHeight", prop);
        stack = getDoublePropertyValue("toteStackHeight", prop);

        return new ToteElevatorConfig(maxDelta, pickup, driving, scoring, step,
                stack);
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

    public double getGamepadDeadbandSize() {
        return gamepadDeadbandSize;
    }

    public double getToteIntakeWheelsSpeed() {
        return toteIntakeWheelsSpeed;
    }

    public double getPrecisionModeScale() {
        return precisionModeScale;
    }

    public Double getDriveTrainRamp() {
        return driveTrainRamp;
    }

    public double getDriveLeftEncoderDPP() {
        return driveLeftEncoderDPP;
    }

    public double getDriveRightEncoderDPP() {
        return driveRightEncoderDPP;
    }

    public double getTotePusherSpeed() {
        return totePusherSpeed;
    }

    public double getToteRetractionTimeout() {
        return toteRetractionTimeout;
    }

    public double getDrivetrainTurnDriveP() {
        return drivetrainTurnDriveP;
    }

    public double getDrivetrainTurnDriveI() {
        return drivetrainTurnDriveI;
    }

    public double getDrivetrainTurnDriveD() {
        return drivetrainTurnDriveD;
    }

    public double getContainerElevatorBrakeThreshold() {
        return containerElevatorBrakeThreshold;
    }

    public double getToteElevatorEncoderDistancePerPulse() {
        return toteElevatorEncoderDistancePerPulse;

    }

    public double getToteElevatorBrakeThreshold() {
        return toteElevatorBrakeThreshold;
    }
}
