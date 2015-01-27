package org.usfirst.frc.team2175.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick gamepad;
	public JoystickButton precisionMode;
	public JoystickButton shifters;

	public double deadbandValue = 0.05;
	public OI() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		gamepad = new Joystick(2);
		precisionMode = new JoystickButton(rightStick, 1);
		shifters = new JoystickButton(leftStick, 1);
	}

	public double getMoveValue() {
		if(!precisionMode.get()){
			return handleDeadband(leftStick.getY());
		}else{
			return handleDeadband(leftStick.getY()*0.5);
		}
	}
	public double getTurnValue() {
		if(!precisionMode.get()){
			return handleDeadband(rightStick.getX());
		}else{
			return handleDeadband(rightStick.getX()*0.5);
		}
	}
	public double handleDeadband(double input){
		if(input<=deadbandValue){
			return 0;
		} else {
			return input;
		}
	}
}
