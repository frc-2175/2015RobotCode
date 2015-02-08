package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteElevator extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public PIDController heightController;

    protected void usePIDOutput(double speed) {
        log.fine("speed=" + speed);
        RobotMap.toteElevatorTalon.set(speed);
    }

    private class HeightControllerHandler implements PIDSource, PIDOutput {
        @Override
        public void pidWrite(double speed) {
            double currentSpeed = RobotMap.toteElevatorTalon.getSpeed();
            if (currentSpeed != speed) {
                log.info("currentSpeed=" + currentSpeed + ", new speed="
                        + speed);
            }
            RobotMap.toteElevatorTalon.set(speed);
        }

        @Override
        public double pidGet() {
            // Return the sensor value for the PID input
            return RobotMap.toteElevatorEncoder.getDistance();
        }
    }

    public ToteElevator() {
        // TODO Find actual distance per pulse
        RobotMap.toteElevatorEncoder.setDistancePerPulse(1 / 50.8);
        RobotMap.toteElevatorEncoder.setReverseDirection(true);
        HeightControllerHandler heightHandler = new HeightControllerHandler();
        heightController = new PIDController(
                Robot.properties.getToteElevatorP(),
                Robot.properties.getToteElevatorI(),
                Robot.properties.getToteElevatorD(), heightHandler,
                heightHandler);
        heightController.setOutputRange(-0.2, 1);
        heightController.setAbsoluteTolerance(.05);
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

    public void setSpeed(double toteElevatorSpeed) {
        double newSpeed;
        if (isAtTop() && toteElevatorSpeed > 0) {
            newSpeed = 0;
        } else if (isAtBottom() && toteElevatorSpeed < 0) {
            newSpeed = 0;
        } else {
            newSpeed = toteElevatorSpeed;
        }
        RobotMap.toteElevatorTalon.set(newSpeed);
        log.fine("requested toteSpeed=" + toteElevatorSpeed + ", newSpeed="
                + newSpeed);
    }

    public void resetEncoder() {
        RobotMap.toteElevatorEncoder.reset();
    }

    public double getHeight() {
        return RobotMap.toteElevatorEncoder.getDistance();
    }

    @Override
    protected void initDefaultCommand() {
    }
}
