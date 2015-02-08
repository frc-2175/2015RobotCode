package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

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
            log.info("new speed=" + speed);
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
        boolean isAtTop = RobotMap.containerSwitch.get();
        log.fine("isAtTop=" + isAtTop);
        return isAtTop;
    }

    // TODO change these two to one sensor boolean

    public boolean containerElevatorIsAtBottom() {
        boolean isAtBottom = !RobotMap.containerSwitch.get();
        log.fine("isAtBottom=" + isAtBottom);
        return isAtBottom;
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
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
