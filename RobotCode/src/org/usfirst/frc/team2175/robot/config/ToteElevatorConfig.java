package org.usfirst.frc.team2175.robot.config;

import java.util.logging.Logger;

public class ToteElevatorConfig {
    private final Logger log = Logger.getLogger(getClass().getName());

    public final double pickup;
    public final double driving;
    public final double scoring;
    public final double step;
    public final double stack;

    public static final String PICKUP_LEVEL_NAME = "pickup";
    public static final String DRIVING_LEVEL_NAME = "driving";
    public static final String SCORING_LEVEL_NAME = "scoring";
    public static final String STEP_LEVEL_NAME = "step";
    public static final String STACK_LEVEL_NAME = "stack";

    private static final int ACCEPTABLE_RANGE = 2;

    public ToteElevatorConfig(double pickup, double driving, double scoring,
            double step, double stack) throws IllegalStateException {
        if (!(pickup <= driving && driving <= scoring && scoring <= step && step <= stack)) {
            throw new IllegalStateException("Elevator levels are not in order.");
        }

        this.pickup = pickup;
        this.driving = driving;
        this.scoring = scoring;
        this.step = step;
        this.stack = stack;
    }

    public double getNextLevelUp(double currentLevel) {
        double newLevelValue;
        String newLevelName;
        if (currentLevel < pickup - ACCEPTABLE_RANGE) {
            newLevelValue = pickup;
            newLevelName = PICKUP_LEVEL_NAME;
        } else if (currentLevel < driving - ACCEPTABLE_RANGE) {
            newLevelValue = driving;
            newLevelName = DRIVING_LEVEL_NAME;
        } else if (currentLevel < scoring - ACCEPTABLE_RANGE) {
            newLevelValue = scoring;
            newLevelName = SCORING_LEVEL_NAME;
        } else if (currentLevel < step - ACCEPTABLE_RANGE) {
            newLevelValue = step;
            newLevelName = STEP_LEVEL_NAME;
        } else {
            newLevelValue = stack;
            newLevelName = STACK_LEVEL_NAME;
        }

        log.fine("currentLevel=" + currentLevel + ", newLevelValue="
                + newLevelValue + ", newLevelName=" + newLevelName);

        return newLevelValue;
    }

    public double getNextLevelDown(double currentLevel) {
        double newLevelValue;
        String newLevelName;
        if (currentLevel > stack + ACCEPTABLE_RANGE) {
            newLevelValue = stack;
            newLevelName = STACK_LEVEL_NAME;
        } else if (currentLevel > step + ACCEPTABLE_RANGE) {
            newLevelValue = step;
            newLevelName = STEP_LEVEL_NAME;
        } else if (currentLevel > scoring + ACCEPTABLE_RANGE) {
            newLevelValue = scoring;
            newLevelName = SCORING_LEVEL_NAME;
        } else if (currentLevel > driving + ACCEPTABLE_RANGE) {
            newLevelValue = driving;
            newLevelName = DRIVING_LEVEL_NAME;
        } else {
            newLevelValue = pickup;
            newLevelName = PICKUP_LEVEL_NAME;
        }

        log.fine("currentLevel=" + currentLevel + ", newLevelValue="
                + newLevelValue + ", newLevelName=" + newLevelName);

        return newLevelValue;
    }
}
