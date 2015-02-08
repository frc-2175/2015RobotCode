package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorManually;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerElevator extends Subsystem {
    private final Logger log = Logger.getLogger(getClass().getName());

    public PIDController containerElevatorController;

    private class ContainerElevatorControllerHandler implements PIDSource,
            PIDOutput {
        @Override
        public void pidWrite(double speed) {
            double currentSpeed = RobotMap.containerElevatorMotor.getSpeed();
            if (currentSpeed != speed) {
                log.info("currentSpeed=" + currentSpeed + ", new speed="
                        + speed);
            }
            RobotMap.containerElevatorMotor.set(speed);
        }

        @Override
        public double pidGet() {
            return getContainerHeight();
        }
    }

    public ContainerElevator() {
        ContainerElevatorControllerHandler containerElevatorControllerHandler = new ContainerElevatorControllerHandler();
        containerElevatorController = new PIDController(0, 0, 0,
                containerElevatorControllerHandler,
                containerElevatorControllerHandler);
        // TODO determine PID constants
        containerElevatorController.setAbsoluteTolerance(0.5);

        // TODO determine distance per pulse and direction of encoder
        RobotMap.containerElevatorEncoder.setDistancePerPulse(0);
        RobotMap.containerElevatorEncoder.setReverseDirection(false);
    }

    public boolean containerElevatorIsAtTop() {
        boolean isOn = RobotMap.containerSwitch.get();
        log.fine("isAtTop=" + isOn);
        return isOn;
    }

    // TODO change these two to one sensor boolean

    // FIXME is this correct? Does one switch tell if it is at top or bottom?
    // what about when it is positioned in the middle?

    public boolean containerElevatorIsAtBottom() {
        boolean isOff = !RobotMap.containerSwitch.get();
        log.fine("isAtBottom=" + isOff);
        return isOff;
    }

    public void setContainerElevatorSpeed(double containerSpeed) {
        double newSpeed;
        if (containerElevatorIsAtTop()
                && RobotMap.containerElevatorMotor.getSpeed() > 0) {
            newSpeed = 0;
        } else if (containerElevatorIsAtBottom()
                && RobotMap.containerElevatorMotor.getSpeed() < 0) {
            newSpeed = 0;
        } else {
            newSpeed = containerSpeed;
        }
        RobotMap.containerElevatorMotor.set(newSpeed);
        log.fine("requested containerSpeed=" + containerSpeed + ", newSpeed="
                + newSpeed);
    }

    public double getContainerHeight() {
        return RobotMap.containerElevatorEncoder.getDistance();
    }

    public void resetElevatorEncoder() {
        RobotMap.containerElevatorEncoder.reset();
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new MoveContainerElevatorManually());
    }
}
