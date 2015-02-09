package org.usfirst.frc.team2175.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.Robot;
import org.usfirst.frc.team2175.robot.RobotMap;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorManually;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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
        boolean isAtTop = RobotMap.containerSwitchTop.get();
        log.fine("isAtTop=" + isAtTop);
        return isAtTop;
    }

    public boolean containerElevatorIsAtBottom() {
        boolean isAtBottom = RobotMap.containerSwitchBottom.get();
        log.fine("isAtBottom=" + isAtBottom);
        return isAtBottom;
    }

    public void setContainerElevatorSpeed(double containerSpeed) {
        double newSpeed;
        if (containerElevatorIsAtTop()
                && Robot.oi.getContainerElevatorSpeed() > 0) {
            newSpeed = 0;
        } else if (containerElevatorIsAtBottom()
                && Robot.oi.getContainerElevatorSpeed() < 0) {
            newSpeed = 0;
        } else {
            if (containerSpeed < -.3) {
                newSpeed = -.3;
            } else {
                newSpeed = containerSpeed;
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
        if (on) {
            RobotMap.containerElevatorBrake.set(DoubleSolenoid.Value.kReverse);
        } else {
            RobotMap.containerElevatorBrake.set(DoubleSolenoid.Value.kForward);
        }
    }

    public double getContainerHeight() {
        return RobotMap.containerElevatorEncoder.getDistance();
    }

    public void resetElevatorEncoder() {
        RobotMap.containerElevatorEncoder.reset();
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new MoveContainerElevatorManually());
    }
}
