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

    @Override
    protected void initDefaultCommand() {
    }
}
