package org.usfirst.frc.team2175.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class containerElevator extends Subsystem {
    public DigitalInput containerTopSwitch;
    public DigitalInput containerBottomSwitch;
    public Talon containerElevatorMotor;
    public Encoder containerElevatorEncoder;

    public containerElevator() {
        containerTopSwitch = new DigitalInput(3);
        containerBottomSwitch = new DigitalInput(4);

        containerElevatorMotor = new Talon(0);

        containerElevatorEncoder = new Encoder(3, 4, false, EncodingType.k4X);
        containerElevatorEncoder.setDistancePerPulse(0);
        containerElevatorEncoder.setReverseDirection(false);

    }

    public boolean containerIsAtTop(){
        return containerTopSwitch.get();
    }
    public boolean containerIsAtBottom(){
        return containerBottomSwitch.get();
    }
    public void setContainerSpeed(double containerSpeed){
        containerElevatorMotor.set(containerSpeed);
    }
    public double getContainerHeight(){
        return containerElevatorEncoder.get();
    }
    public void resetElevatorEncoder(){
        containerElevatorEncoder.reset();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
