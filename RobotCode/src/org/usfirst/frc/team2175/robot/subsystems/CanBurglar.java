package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CanBurglar extends Subsystem {

    private final Logger log = Logger.getLogger(getClass().getName());

    public void runCanBurglarMotor(double speed) {
        RobotMap.canBurglarMotor.set(speed);
    }

    @Override
    public void initDefaultCommand() {
    }
}
