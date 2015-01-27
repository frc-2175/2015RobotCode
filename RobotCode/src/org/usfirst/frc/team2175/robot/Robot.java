
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.robot.commands.*;
import org.usfirst.frc.team2175.robot.subsystems.ContainerElevator;
import org.usfirst.frc.team2175.robot.subsystems.ContainerIntake;
import org.usfirst.frc.team2175.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2175.robot.subsystems.PIDToteElevator;
import org.usfirst.frc.team2175.robot.subsystems.ToteElevator;
import org.usfirst.frc.team2175.robot.subsystems.ToteIntake;
import org.usfirst.frc.team2175.robot.subsystems.TotePusher;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final PIDToteElevator pidToteElevator = new PIDToteElevator();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final ToteElevator toteElevator = new ToteElevator();
	public static final TotePusher totePusher = new TotePusher();
	public static final ContainerElevator containerElevator = new ContainerElevator(); 
	public static final ToteIntake toteIntake = new ToteIntake();
	public static final ContainerIntake containerIntake = new ContainerIntake();
	
	public static OI oi;

    Command autonomousCommand;
    SendableChooser autonChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new Auton0DoNothing();
        
        autonChooser = new SendableChooser();
        autonChooser.addDefault("0 - No Action", new Auton0DoNothing());
        autonChooser.addDefault("1 - Drive into Auto Zone", new Auton1DriveForward());
        //TODO add all of these
        SmartDashboard.putData("Autonomous Routine",autonChooser);
        
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command according to the chooser on the dashboard
        autonomousCommand = (Command)autonChooser.getSelected();
        autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
