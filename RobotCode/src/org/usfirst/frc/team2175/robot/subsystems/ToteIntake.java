package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
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

    public void pushOut() {
        double pusherSpeed = Robot.properties.getTotePusherSpeed();
        log.fine("Pushing Out");
        while (!isPusherExtended()) {
            RobotMap.totePusher.set(pusherSpeed);
        }
        RobotMap.totePusher.set(0);
        log.fine("Done Pushing Out");
        log.fine("Retracting ");
        while (!isPusherRetracted()) {
            RobotMap.totePusher.set(pusherSpeed);
        }
        RobotMap.totePusher.set(0);
        log.fine("Done Retracting");
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
        boolean isExtended = RobotMap.pusherSwitch.get();
        log.fine("isExtended=" + isExtended);
        return isExtended;
    }

    public boolean isPusherRetracted() {
        boolean isRetracted = !RobotMap.pusherSwitch.get();
        log.fine("isRetracted=" + isRetracted);
        return isRetracted;
    }

    public void setPusherMotorSpeed(double speed) {
        RobotMap.totePusher.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
    }
}
