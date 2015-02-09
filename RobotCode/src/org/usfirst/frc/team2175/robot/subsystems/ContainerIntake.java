package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerIntake extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public void setIntakeArms(boolean on) {
        log.fine("on=" + on);
        if (on) {
            RobotMap.containerIntakeArms.set(DoubleSolenoid.Value.kForward);
        } else {
            RobotMap.containerIntakeArms.set(DoubleSolenoid.Value.kReverse);
        }
    }

    @Override
    public void initDefaultCommand() {
    }
}
