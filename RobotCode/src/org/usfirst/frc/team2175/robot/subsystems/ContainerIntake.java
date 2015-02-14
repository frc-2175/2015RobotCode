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
    private boolean spatulaOn;

    public void setIntakeArms(boolean on) {
        Value value;

        if (on) {
            value = DoubleSolenoid.Value.kForward;
        } else {
            value = DoubleSolenoid.Value.kReverse;
        }
        log.fine("Intake arms set to " + on + ", value=" + value);
        RobotMap.containerIntakeArms.set(value);

    }

    public void setSpatula(boolean spatulaOn) {

        this.spatulaOn = spatulaOn;
        Value value;
        if (spatulaOn) {
            value = DoubleSolenoid.Value.kForward;
        } else {
            value = DoubleSolenoid.Value.kReverse;
        }

        log.fine("Spatula set to " + spatulaOn + ", value=" + value);
        RobotMap.containerSpatula.set(value);
    }

    public boolean isSpatulaRetracted() {
        return RobotMap.containerSpatula.get() == DoubleSolenoid.Value.kReverse;
    }

    @Override
    public void initDefaultCommand() {
    }
}
