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
 * @author FRC 2175
 */

public class ToteElevator extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public PIDController toteElevatorController;
    private boolean brakeOn;

    protected void usePIDOutput(double speed) {
        log.fine("speed=" + speed);
        setToteElevatorSpeed(speed);
    }

    /**
     * The PID handler for the tote elevator. Wraps the motor control and
     * encoder with PIDSource and PIDOutput
     *
     * @author FRC 2175
     *
     */

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
        // TODO check distance per pulse (I think this is right, but not
        // sure)
        RobotMap.toteElevatorEncoder.setDistancePerPulse(Robot.properties
                .getToteElevatorEncoderDistancePerPulse());
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

    /**
     * Determines whether the tote elevator is at the bottom according to the
     * value of a hall effect sensor
     *
     * @return Returns the inverse of the value of the bottom tote switch
     */
    public boolean isAtBottom() {
        boolean isAtBottom = !RobotMap.toteSwitchBottom.get();
        log.fine("isAtBottom=" + isAtBottom);
        return isAtBottom;
    }

    /**
     * Determines whether the tote elevator is at the top according to the value
     * of a hall effect sensor
     *
     * @return Returns the inverse of the value of the top tote switch
     */
    public boolean isAtTop() {
        boolean isAtTop = !RobotMap.toteSwitchTop.get();
        log.fine("isAtTop=" + isAtTop);
        return isAtTop;
    }

    /**
     * This sets the tote elevator speed after checking to make sure it is not
     * passing the top or bottom by using ToteElevator.isAtTop() and
     * ToteElevator.isAtBottom()
     *
     * @param toteElevatorSpeed
     *            : The commanded elevator speed
     */
    public void setToteElevatorSpeed(double toteElevatorSpeed) {
        double newSpeed;
        boolean toteIntakeState = Robot.toteIntake.toteIntakeIsOpen();
        if (isAtTop() && Robot.oi.getToteElevatorSpeed() > 0) {
            newSpeed = 0;
        } else if (isAtBottom() && Robot.oi.getToteElevatorSpeed() < 0) {
            newSpeed = 0;
//        } else if (toteIntakeState == false) {
//            newSpeed = 0;
        } else {
            newSpeed = toteElevatorSpeed;
        }
        RobotMap.toteElevatorMotor.set(newSpeed);
        log.fine("requested toteSpeed=" + toteElevatorSpeed + ", newSpeed="
                + newSpeed);
        updateBrakeSetting();
    }

    /**
     * Applies the brake setting obtained from ToteElevator.updateBrakeSetting()
     *
     * @param on
     *            : Value the solenoid is set to
     */
    public void setBrake(boolean on) {
        // This is supposed to be negated, don't change it
        if (!on) {
            RobotMap.toteElevatorBrake.set(true);
        } else {
            RobotMap.toteElevatorBrake.set(false);
        }
    }

    /**
     * Gets the output of the tote elevator motor
     *
     * @return The output of the tote elevator motor
     */
    public double getMotorOutput() {
        return RobotMap.toteElevatorMotor.get();
    }

    /**
     * Determines if the brake should be on or off based on the commanded value,
     * then sets it using ToteElevator.setBrake()
     */
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

    /**
     * @return The value of the tote elevator brake
     */
    public boolean getBrake() {
        return brakeOn;
    }

    /**
     * Resets the tote elevator encoder
     */
    public void resetEncoder() {
        RobotMap.toteElevatorEncoder.reset();
    }

    /**
     * @return The height of the tote elevator motor
     */
    public double getHeight() {
        return RobotMap.toteElevatorEncoder.getDistance();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveToteElevatorManually());
    }
}
