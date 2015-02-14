package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
        Value value;
        if (on) {
            value = DoubleSolenoid.Value.kForward;
        } else {
            value = DoubleSolenoid.Value.kReverse;
        }
        RobotMap.toteIntakeArms.set(value);
    }

    public void setPusherSpeed(double speed) {
        if (speed > 0 && !isPusherExtended()) {
            RobotMap.totePusher.set(speed);
        } else if (speed < 0 && !isPusherRetracted()) {
            RobotMap.totePusher.set(speed);
        } else {
            RobotMap.totePusher.set(0);
        }
    }

    public void setMotorSpeed(double armSpeed) {
        double newSpeed;
        if (isPusherExtended() && armSpeed >= 0) {
            newSpeed = 0;
        } else if (isPusherRetracted() && armSpeed <= 0) {
            newSpeed = 0;
        } else {
            newSpeed = armSpeed;
        }
        RobotMap.totePusher.set(newSpeed);
        log.fine("requested armSpeed=" + armSpeed + ", newSpeed=" + newSpeed);
    }

    public boolean isPusherExtended() {
        boolean isExtended = RobotMap.pusherOutSwitch.get();
        log.fine("isExtended=" + isExtended);
        return isExtended;
    }

    public boolean isPusherRetracted() {
        boolean isRetracted = RobotMap.pusherInSwitch.get();
        log.fine("isRetracted=" + isRetracted);
        return isRetracted;
    }

    public boolean isIntakeArmsOut() {
        return RobotMap.toteIntakeArms.get() == DoubleSolenoid.Value.kReverse;
    }

    @Override
    protected void initDefaultCommand() {
    }
}
