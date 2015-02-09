package org.usfirst.frc.team2175.robot.config;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerElevatorConfig extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public final double downSpeed;
    
    public final double level0;
    public final double level1;
    public final double level2;
    public final double level3;
    public final double level4;

    public static final String LEVEL0_NAME = "level-0";
    public static final String LEVEL1_NAME = "level-1";
    public static final String LEVEL2_NAME = "level-2";
    public static final String LEVEL3_NAME = "level-3";
    public static final String LEVEL4_NAME = "level-4";

    private static final int ACCEPTABLE_RANGE = 2;

    public ContainerElevatorConfig(double downSpeed, double level0, double level1, double level2,
            double level3, double level4) throws IllegalStateException {
        if (!(level0 <= level1 && level1 <= level2 && level2 <= level3 && level3 <= level4)) {
            throw new IllegalStateException("Elevator levels are not in order.");
        }
        
        this.downSpeed = downSpeed;
        this.level0 = level0;
        this.level1 = level1;
        this.level2 = level3;
        this.level3 = level3;
        this.level4 = level4;
        
    }

    public double getNextLevelUp(double currentLevel) {
        double newLevelValue;
        String newLevelName;
        if (currentLevel < level0 - ACCEPTABLE_RANGE) {
            newLevelValue = level0;
            newLevelName = LEVEL0_NAME;
        } else if (currentLevel < level1 - ACCEPTABLE_RANGE) {
            newLevelValue = level1;
            newLevelName = LEVEL1_NAME;
        } else if (currentLevel < level2 - ACCEPTABLE_RANGE) {
            newLevelValue = level2;
            newLevelName = LEVEL2_NAME;
        } else if (currentLevel < level3 - ACCEPTABLE_RANGE) {
            newLevelValue = level3;
            newLevelName = LEVEL3_NAME;
        } else {
            newLevelValue = level4;
            newLevelName = LEVEL4_NAME;
        }

        log.fine("currentLevel=" + currentLevel + ", newLevelValue="
                + newLevelValue + ", newLevelName=" + newLevelName);

        return newLevelValue;
    }

    public double getNextLevelDown(double currentLevel) {
        double newLevelValue;
        String newLevelName;
        if (currentLevel > level4 + ACCEPTABLE_RANGE) {
            newLevelValue = level4;
            newLevelName = LEVEL0_NAME;
        } else if (currentLevel > level3 + ACCEPTABLE_RANGE) {
            newLevelValue = level3;
            newLevelName = LEVEL0_NAME;
        } else if (currentLevel > level2 + ACCEPTABLE_RANGE) {
            newLevelValue = level2;
            newLevelName = LEVEL0_NAME;
        } else if (currentLevel > level1 + ACCEPTABLE_RANGE) {
            newLevelValue = level1;
            newLevelName = LEVEL0_NAME;
        } else {
            newLevelValue = level0;
            newLevelName = LEVEL0_NAME;
        }

        log.fine("currentLevel=" + currentLevel + ", newLevelValue="
                + newLevelValue + ", newLevelName=" + newLevelName);

        return newLevelValue;
    }
    
    

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
