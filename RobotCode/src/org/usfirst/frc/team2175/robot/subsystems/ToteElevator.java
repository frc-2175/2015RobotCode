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
            log.info("new speed=" + speed);
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
        // Add other encoder-related initializations here if needed.
    }

    public boolean isAtBottom() {
        boolean isOff = !RobotMap.toteSwitch.get();
        log.fine("isAtBottom=" + isOff);
        return isOff;
    }

    // TODO change these two sensors to one boolean

    // FIXME is this correct? Does one switch tell if it is at top or bottom?
    // what about when it is positioned in the middle?

    public boolean isAtTop() {
        boolean isOn = RobotMap.toteSwitch.get();
        log.fine("isAtTop=" + isOn);
        return isOn;
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
        // TODO Auto-generated method stub
    }
}
