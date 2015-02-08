package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerIntake extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void setIntakeArms(boolean on) {
        log.fine("on=" + on);
        RobotMap.ContainerIntakeArms.set(on);
    }

    @Override
    public void initDefaultCommand() {
    }
}
