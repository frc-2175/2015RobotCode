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
    public boolean armsOpen;

    private static final DoubleSolenoid.Value OPEN_VALUE = DoubleSolenoid.Value.kReverse;
    private static final DoubleSolenoid.Value CLOSED_VALUE = DoubleSolenoid.Value.kForward;

    public void setRightWheelSpeed(double wheelSpeed) {
        RobotMap.toteIntakeWheelMotorRight.set(wheelSpeed);
        log.fine("Running tote wheel right at speed "
                + Robot.properties.getToteIntakeWheelsSpeed());
    }

    public void setLeftWheelSpeed(double wheelSpeed) {
        RobotMap.toteIntakeWheelMotorLeft.set(-wheelSpeed);
        log.fine("Running tote wheel left at speed "
                + Robot.properties.getToteIntakeWheelsSpeed());
    }

    /**
     * Sets the state of the tote intake arms.
     *
     * @param isOpen
     */
    public void setIntakeArms(boolean isOpen) {
        log.fine("isOpen=" + isOpen);
        Value value;
        if (isOpen) {
            value = OPEN_VALUE;
            armsOpen = true;
        } else {
            value = CLOSED_VALUE;
            armsOpen = false;
        }
        RobotMap.toteIntakeArms.set(value);
    }

    public boolean toteIntakeIsOpen() {
        DoubleSolenoid.Value intakeValue = RobotMap.toteIntakeArms.get();
        return (intakeValue == OPEN_VALUE || intakeValue == DoubleSolenoid.Value.kOff);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
