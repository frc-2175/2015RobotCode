package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorManually;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteElevator extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public PIDController toteElevatorController;
    private boolean brakeOn;

    protected void usePIDOutput(double speed) {
        log.fine("speed=" + speed);
        RobotMap.toteElevatorMotor.set(speed);
    }

    private class HeightControllerHandler implements PIDSource, PIDOutput {
        @Override
        public void pidWrite(double speed) {
            double currentSpeed = RobotMap.toteElevatorMotor.getSpeed();
            if (currentSpeed != speed) {
                log.info("currentSpeed=" + currentSpeed + ", new speed="
                        + speed);
            }
            setToteElevatorSpeed(speed);
        }

        @Override
        public double pidGet() {
            // Return the sensor value for the PID input
            return RobotMap.toteElevatorEncoder.getDistance();
        }
    }

    public ToteElevator() {
        // TODO Find actual distance per pulse (I think this is right, but not
        // sure)
        RobotMap.toteElevatorEncoder.setDistancePerPulse(1 / 50.8);
        RobotMap.toteElevatorEncoder.setReverseDirection(true);
        HeightControllerHandler heightHandler = new HeightControllerHandler();
        toteElevatorController = new PIDController(
                Robot.properties.getToteElevatorP(),
                Robot.properties.getToteElevatorI(),
                Robot.properties.getToteElevatorD(), heightHandler,
                heightHandler);
        toteElevatorController.setOutputRange(-0.2, 1);
        toteElevatorController.setAbsoluteTolerance(.05);
    }

    public boolean isAtBottom() {
        boolean isAtBottom = RobotMap.toteSwitchBottom.get();
        log.fine("isAtBottom=" + isAtBottom);
        return isAtBottom;
    }

    public boolean isAtTop() {
        boolean isAtTop = RobotMap.toteSwitchTop.get();
        log.fine("isAtTop=" + isAtTop);
        return isAtTop;
    }

    public void setToteElevatorSpeed(double toteElevatorSpeed) {
        double newSpeed;
        if (isAtTop() && toteElevatorSpeed > 0) {
            newSpeed = 0;
        } else if (isAtBottom() && toteElevatorSpeed < 0) {
            newSpeed = 0;
        } else {
            newSpeed = toteElevatorSpeed;
        }
        RobotMap.toteElevatorMotor.set(newSpeed);
        log.fine("requested toteSpeed=" + toteElevatorSpeed + ", newSpeed="
                + newSpeed);
        updateBrakeSetting();
    }

    public void setBrake(boolean on) {
        // This is supposed to be negated, don't change it
        if (!on) {
            RobotMap.toteElevatorBrake.set(true);
        } else {
            RobotMap.toteElevatorBrake.set(false);
        }
    }

    public double getMotorOutput() {
        return RobotMap.toteElevatorMotor.get();
    }

    public void updateBrakeSetting() {
        double motorOutput = getMotorOutput();

        log.fine("motorOutput=" + motorOutput);

        if (Math.abs(motorOutput) < 0.05) {
            setBrake(true);
            brakeOn = true;
        } else {
            setBrake(false);
            brakeOn = false;
        }
    }

    public boolean getBrake() {
        return brakeOn;
    }

    public void resetEncoder() {
        RobotMap.toteElevatorEncoder.reset();
    }

    public double getHeight() {
        return RobotMap.toteElevatorEncoder.getDistance();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveToteElevatorManually());
    }
}
