package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Ramp;
import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorManually;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The control class for the tote elevator, with a PID wrapper class contained
 * within
 *
 * @author FRC 2175
 */
public class ContainerElevator extends Subsystem {

    private final Logger log = Logger.getLogger(getClass().getName());
    private Ramp containerRamp;

    public PIDController containerElevatorController;

    /**
     * The PID wrapper class for the container elevator. It uses
     * setContainerElevatorSpeed as pidWrite and getContainerHeight as pidGet
     *
     * @author FRC 2175
     *
     */
    private class ContainerElevatorControllerHandler implements PIDSource,
            PIDOutput {
        @Override
        public void pidWrite(double speed) {
            double currentSpeed = RobotMap.containerElevatorMotor.getSpeed();
            if (currentSpeed != speed) {
                log.info("currentSpeed=" + currentSpeed + ", new speed="
                        + speed);
            }
            setContainerElevatorSpeed(speed);
            updateBrakeSetting();
        }

        @Override
        public double pidGet() {
            return getContainerHeight();
        }
    }

    public ContainerElevator() {
        ContainerElevatorControllerHandler containerElevatorControllerHandler = new ContainerElevatorControllerHandler();
        containerElevatorController = new PIDController(
                Robot.properties.getContainerElevatorP(),
                Robot.properties.getContainerElevatorI(),
                Robot.properties.getContainerElevatorD(),
                containerElevatorControllerHandler,
                containerElevatorControllerHandler);
        containerElevatorController.setOutputRange(-.5, 1);
        containerElevatorController.setAbsoluteTolerance(5);
        containerRamp = new Ramp(Robot.properties.containerConfig.maxDelta);

    }

    private boolean brakeOn;

    public boolean containerElevatorIsAtTop() {
        boolean isAtTop = !RobotMap.containerSwitchTop.get();
        log.fine("isAtTop=" + isAtTop);
        return isAtTop;
    }

    public boolean containerElevatorIsAtBottom() {
        boolean isAtBottom = !RobotMap.containerSwitchBottom.get();
        log.fine("isAtBottom=" + isAtBottom);
        return isAtBottom;
    }

    public void setContainerElevatorSpeed(double containerSpeed) {
        double newSpeed;
        double downSpeed = Robot.properties.containerConfig.downSpeed;
        if (containerElevatorIsAtTop()
                && Robot.oi.getContainerElevatorSpeed() > 0) {
            newSpeed = 0;
        } else if (containerElevatorIsAtBottom()
                && Robot.oi.getContainerElevatorSpeed() < 0) {
            newSpeed = 0;
        } else {
            if (containerSpeed < downSpeed) {
                newSpeed = containerRamp.rampInput(downSpeed);
            } else {
                newSpeed = containerRamp.rampInput(containerSpeed);
            }
        }

        RobotMap.containerElevatorMotor.set(newSpeed);
        log.fine("requested containerSpeed=" + containerSpeed + ", newSpeed="
                + newSpeed);
    }

    public double getMotorOutput() {
        return RobotMap.containerElevatorMotor.get();
    }

    public void setBrake(boolean on) {
        // This is correct, don't change it
        if (!on) {
            RobotMap.containerElevatorBrake.set(true);
            brakeOn = true;
        } else {
            RobotMap.containerElevatorBrake.set(false);
            brakeOn = false;
        }
    }

    public double getContainerHeight() {
        return RobotMap.containerElevatorEncoder.getDistance();
    }

    public void resetElevatorEncoder() {
        RobotMap.containerElevatorEncoder.reset();
    }

    public void updateBrakeSetting() {
        double motorOutput = Robot.containerElevator.getMotorOutput();

        log.fine("motorOutput=" + motorOutput);

        if (Math.abs(motorOutput) < Robot.properties
                .getContainerElevatorBrakeThreshold()) {
            Robot.containerElevator.setBrake(true);
        } else {
            Robot.containerElevator.setBrake(false);
        }
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new MoveContainerElevatorManually());
    }

    public boolean getBrake() {
        return brakeOn;
    }

}
