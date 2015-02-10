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
        containerElevatorController = new PIDController(.005, 0, 0.001,
                containerElevatorControllerHandler,
                containerElevatorControllerHandler);
        containerElevatorController.setOutputRange(-.5, 1);
        // TODO determine PID constants
        containerElevatorController.setAbsoluteTolerance(5);

        // TODO determine distance per pulse and direction of encoder
        
        
    }

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
                newSpeed = downSpeed;
            } else {
                newSpeed = containerSpeed;
            }
        	
        }
//        newSpeed = containerSpeed;
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
    
    public void updateBrakeSetting() {
        double motorOutput = Robot.containerElevator.getMotorOutput();

        log.fine("motorOutput=" + motorOutput);

        if (Math.abs(motorOutput) < 0.05) {
            Robot.containerElevator.setBrake(true);
        } else {
            Robot.containerElevator.setBrake(false);
        }
    }
    
    
    @Override
    public void initDefaultCommand() {
//        setDefaultCommand(new MoveContainerElevatorManually());
    }
}
