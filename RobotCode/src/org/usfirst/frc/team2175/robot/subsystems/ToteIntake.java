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
        RobotMap.totePusher.set(armSpeed);
        log.fine("requested armSpeed=" + armSpeed + ", newSpeed=" + armSpeed);
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

    public boolean toteIntakeIsOpen() {
    	DoubleSolenoid.Value intakeValue = RobotMap.toteIntakeArms.get();
        return (intakeValue == OPEN_VALUE || intakeValue == DoubleSolenoid.Value.kOff);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new StopPusher());
    }
}
