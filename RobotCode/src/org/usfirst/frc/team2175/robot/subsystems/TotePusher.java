package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TotePusher extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public void setMotorSpeed(double armSpeed) {
        double newSpeed;
        if (isPusherExtended() && armSpeed >= 0) {
            newSpeed = 0;
        }
        // FIXME is this an else if?
        if (isPusherRetracted() && armSpeed <= 0) {
            newSpeed = 0;
        } else {
            newSpeed = armSpeed;
        }
        RobotMap.totePusherArm.set(newSpeed);
        log.fine("requested armSpeed=" + armSpeed + ", newSpeed=" + newSpeed);
    }

    public boolean isPusherExtended() {
        boolean isExtended = RobotMap.pusherSwitch.get();
        log.fine("isExtended=" + isExtended);
        return isExtended;
    }

    // TODO change these two into one sensor boolean

    // FIXME is this correct? Does true represent extended or extracted?

    public boolean isPusherRetracted() {
        boolean isRetracted = !RobotMap.pusherSwitch.get();
        log.fine("isRetracted=" + isRetracted);
        return isRetracted;
    }

    @Override
    protected void initDefaultCommand() {
    }
}
