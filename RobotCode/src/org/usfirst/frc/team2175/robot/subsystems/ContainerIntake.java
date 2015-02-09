package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerIntake extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public void setIntakeArms(boolean on) {
        Value value;
        if (on) {
            value = DoubleSolenoid.Value.kForward;
        } else {
            value = DoubleSolenoid.Value.kReverse;
        }

        log.fine("on=" + on + ", value=" + value);
        RobotMap.containerIntakeArms.set(value);
    }

    @Override
    public void initDefaultCommand() {
    }
}
