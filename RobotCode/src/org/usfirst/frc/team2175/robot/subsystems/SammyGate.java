package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SammyGate extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public void setSammyGate(boolean position) {
        log.fine("position=" + position);
        Value value;
        if (position) {
            value = DoubleSolenoid.Value.kForward;
        } else {
            value = DoubleSolenoid.Value.kReverse;
        }
        RobotMap.SammyGatePiston.set(value);
    }

    @Override
    public void initDefaultCommand() {

    }
}
