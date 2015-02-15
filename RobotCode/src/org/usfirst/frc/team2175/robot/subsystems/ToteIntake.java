package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.single.StopPusher;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteIntake extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public void setWheelSpeed(int wheel, double wheelSpeed) {
        if (wheel == 0) {
            RobotMap.toteIntakeWheelMotorLeft.set(wheelSpeed);
            log.fine("Running tote wheel " + wheel + " at speed "
                    + Robot.properties.getToteIntakeWheelsSpeed());
        } else {
            RobotMap.toteIntakeWheelMotorRight.set(wheelSpeed);
            log.fine("Running tote wheel " + wheel + " at speed "
                    + Robot.properties.getToteIntakeWheelsSpeed());
        }
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
        if (speed > 0 && isPusherExtended()) {
            RobotMap.totePusher.set(0);
        } else if (speed < 0 && isPusherRetracted()) {
            RobotMap.totePusher.set(0);
        } else {
            RobotMap.totePusher.set(speed);
        }
    }

    public void setMotorSpeed(double armSpeed) {
        double newSpeed;
        // if (isPusherExtended() && armSpeed > 0) {
        // newSpeed = 0;
        // } else if (isPusherRetracted() && armSpeed < 0) {
        // newSpeed = 0;
        // } else {
        newSpeed = armSpeed;
        // }
        RobotMap.totePusher.set(newSpeed);
        log.fine("requested armSpeed=" + armSpeed + ", newSpeed=" + newSpeed);
    }

    public boolean isPusherExtended() {
        boolean isExtended = !RobotMap.pusherOutSwitch.get();
        log.fine("isExtended=" + isExtended);
        return isExtended;
    }

    public boolean isPusherRetracted() {
        boolean isRetracted = !RobotMap.pusherInSwitch.get();
        log.fine("isRetracted=" + isRetracted);
        return isRetracted;
    }

    public boolean isIntakeArmsOut() {
        return RobotMap.toteIntakeArms.get() == DoubleSolenoid.Value.kReverse;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new StopPusher());
    }
}
