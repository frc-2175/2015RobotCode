package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteIntake extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public void setWheelSpeed(double wheelSpeed) {
        log.fine("wheelSpeed=" + wheelSpeed);
        RobotMap.toteIntakeWheelMotor.set(wheelSpeed);
    }

    public void setIntakeArms(boolean on) {
        log.fine("on=" + on);
        RobotMap.toteIntakeArms.set(on);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
