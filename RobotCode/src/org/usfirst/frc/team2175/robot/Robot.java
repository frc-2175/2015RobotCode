package org.usfirst.frc.team2175.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.commands.auto.Auton0DoNothing;
import org.usfirst.frc.team2175.robot.commands.auto.Auton1DriveForward;
import org.usfirst.frc.team2175.robot.commands.auto.Auton1DriveLeft;
import org.usfirst.frc.team2175.robot.commands.auto.Auton2Push1Tote;
import org.usfirst.frc.team2175.robot.commands.auto.Auton2Push2Totes;
import org.usfirst.frc.team2175.robot.commands.auto.Auton2Push3Totes;
import org.usfirst.frc.team2175.robot.commands.auto.Auton3StackToteInAutoZone;
import org.usfirst.frc.team2175.robot.commands.auto.AutonMinus1Test;
import org.usfirst.frc.team2175.robot.config.LoggingConfiguration;
import org.usfirst.frc.team2175.robot.config.RobotConfig;
import org.usfirst.frc.team2175.robot.subsystems.ContainerElevator;
import org.usfirst.frc.team2175.robot.subsystems.ContainerIntake;
import org.usfirst.frc.team2175.robot.subsystems.Drivetrain;
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
    private final Logger log = Logger.getLogger(getClass().getName());

    public static Drivetrain drivetrain;
    public static ToteElevator toteElevator;
    public static TotePusher totePusher;
    public static ContainerElevator containerElevator;
    public static ToteIntake toteIntake;
    public static ContainerIntake containerIntake;

    public static OI oi;
    public static RobotConfig properties;

    Command autonomousCommand;
    SendableChooser autonChooser;
    SendableChooser driveChooser;

    private class SchedulerTask extends java.util.TimerTask {
        @Override
        public void run() {
            Scheduler.getInstance().run();
        }
    }

    private java.util.Timer controlLoop;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        new LoggingConfiguration().initializeLogging();

        properties = new RobotConfig();

        RobotMap.init();

        makeSubsystems();

        oi = new OI();

        makeControlLoop();

        makeAutonChooser();

        // instantiate the command used for the autonomous period
        autonomousCommand = new Auton0DoNothing();
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
        // schedule the autonomous command according to the chooser on the
        // dashboard
        autonomousCommand = (Command) autonChooser.getSelected();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }

    }

    /**
     * This function is called when the disabled button is hit. You can use it
     * to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {
    }

    /**
     *
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        double distance = RobotMap.toteElevatorEncoder.getDistance();
        final String msg = "Distance robot has driven since last reset="
                + distance;
        log.info(msg);
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }

    private void makeSubsystems() {
        drivetrain = new Drivetrain();
        toteElevator = new ToteElevator();
        totePusher = new TotePusher();
        containerElevator = new ContainerElevator();
        toteIntake = new ToteIntake();
        containerIntake = new ContainerIntake();
    }

    private void makeControlLoop() {
        controlLoop = new java.util.Timer();
        controlLoop.schedule(new SchedulerTask(), 0L, (10));
    }

    private void makeAutonChooser() {
        autonChooser = new SendableChooser();

        // TODO add all of the auto routines as they are made
        autonChooser.addDefault("-1 - Test", new AutonMinus1Test());
        autonChooser.addDefault("0 - No Action", new Auton0DoNothing());
        autonChooser.addDefault("1 - Drive straight into Auto Zone",
                new Auton1DriveForward());
        autonChooser.addDefault("2 - Drive left into Auto Zone",
                new Auton1DriveLeft()); // TODO re evaluate need for this
                                        // command
        autonChooser.addDefault("3 - Push 1 tote into Auto Zone",
                new Auton2Push1Tote());
        autonChooser.addDefault("4 - Push 2 totes into Auto Zone",
                new Auton2Push2Totes());
        autonChooser.addDefault("5 - Push 3 totes into Auto Zone",
                new Auton2Push3Totes());
        autonChooser.addDefault(
                "6 - Stack 3 Totes and put them into Auto Zone",
                new Auton3StackToteInAutoZone());

        SmartDashboard.putData("Autonomous Routine", autonChooser);
    }

    private void makeDriveChooser() {
        driveChooser = new SendableChooser();

        // drivechooser.addDefault()
    }
}
