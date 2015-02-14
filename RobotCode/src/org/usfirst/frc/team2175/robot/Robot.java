package org.usfirst.frc.team2175.robot;

import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.commands.auto.AutonDoNothing;
import org.usfirst.frc.team2175.robot.commands.auto.AutonDriveForward;
import org.usfirst.frc.team2175.robot.commands.auto.AutonMinus1Test;
import org.usfirst.frc.team2175.robot.commands.auto.AutonStack1Tote;
import org.usfirst.frc.team2175.robot.commands.auto.AutonStack1ToteGrab1Container;
import org.usfirst.frc.team2175.robot.commands.auto.AutonStack2Totes;
import org.usfirst.frc.team2175.robot.commands.auto.AutonStack2TotesGrab1Container;
import org.usfirst.frc.team2175.robot.commands.auto.AutonStack3TotesGrab1Container;
import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveSquaredInputs;
import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithSticks;
import org.usfirst.frc.team2175.robot.commands.single.TankDriveForTesting;
import org.usfirst.frc.team2175.robot.commands.single.TankDriveWithSticks;
import org.usfirst.frc.team2175.robot.config.KeymapConfig;
import org.usfirst.frc.team2175.robot.config.LoggingConfiguration;
import org.usfirst.frc.team2175.robot.config.PDPCurrentLogger;
import org.usfirst.frc.team2175.robot.config.RobotConfig;
import org.usfirst.frc.team2175.robot.subsystems.ContainerElevator;
import org.usfirst.frc.team2175.robot.subsystems.ContainerIntake;
import org.usfirst.frc.team2175.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2175.robot.subsystems.ToteElevator;
import org.usfirst.frc.team2175.robot.subsystems.ToteIntake;

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

    public boolean doNoodle;

    // TODO convert these to instances
    public static OI oi;
    public static Drivetrain drivetrain;
    public static ToteElevator toteElevator;
    public static ContainerElevator containerElevator;
    public static ToteIntake toteIntake;
    public static ContainerIntake containerIntake;
    public static Ramp toteRamp;
    public static Ramp containerRamp;

    public static RobotConfig properties;
    public static KeymapConfig keymap;
    public static PDPCurrentLogger pdpLogger;

    Command autonomousCommand;
    Command driveChoice;
    SendableChooser autonChooser;
    SendableChooser driveChooser;

    static {
        new LoggingConfiguration().initializeLogging();
    }

    private class SchedulerTask extends java.util.TimerTask {
        @Override
        public void run() {
            Scheduler.getInstance().run();
        }
    }

    private class PDPLoggerTask extends java.util.TimerTask {
        @Override
        public void run() {
            pdpLogger.logPDPValues();
        }
    }

    public java.util.Timer controlLoop;
    public java.util.Timer pdpLoggingLoop;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        log.info("Robot configuration starting");

        properties = new RobotConfig();

        keymap = new KeymapConfig();

        new RobotMap().init();

        makeSubsystems();

        makeDriveChooser();

        oi = new OI();

        pdpLogger = new PDPCurrentLogger();

        makePDPLoggingLoop();

        makeControlLoop();

        makeAutonChooser();

        smartDashboardUpdate();

        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonDoNothing();

        log.info("Robot configuration finished");
    }

    @Override
    public void disabledPeriodic() {
        smartDashboardUpdate();

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
        driveChoice = (Command) driveChooser.getSelected();
        driveChoice.start();

        smartDashboardUpdate();
        makePDPLoggingLoop();

        // This might run way too fast, requires testing on roboRIO with actual
        // PDP setup

    }

    /**
     * This function is called when the disabled button is hit. You can use it
     * to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {
        containerElevator.containerElevatorController.disable();
        pdpLoggingLoop.cancel();
    }

    /**
     *
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        // This method called ****over 35 times per second****.
        // commented out logging it until determined that we need it
        // double distance = RobotMap.toteElevatorEncoder.getDistance();
        // final String msg = "Distance robot has driven since last reset="
        // + distance;
        // log.info(msg);

        smartDashboardUpdate();

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
        containerElevator = new ContainerElevator();
        toteIntake = new ToteIntake();
        containerIntake = new ContainerIntake();
        toteRamp = new Ramp(Robot.properties.toteConfig.maxDelta);
        containerRamp = new Ramp(Robot.properties.containerConfig.maxDelta);
    }

    private void makeControlLoop() {
        controlLoop = new java.util.Timer();
        controlLoop.schedule(new SchedulerTask(), 0L, (10));
    }

    private void makePDPLoggingLoop() {
        pdpLogger.initPDPLogging();

        pdpLoggingLoop = new java.util.Timer();
        pdpLoggingLoop.schedule(new PDPLoggerTask(), 0L, (40));
    }

    private void makeAutonChooser() {
        autonChooser = new SendableChooser();

        // TODO add all of the auto routines as they are made
        autonChooser.addDefault("-1 - Test", new AutonMinus1Test());
        autonChooser.addDefault("0 - No Action", new AutonDoNothing());
        autonChooser.addDefault("1 - Drive straight into Auto Zone",
                new AutonDriveForward());
        autonChooser.addDefault("2 - Stack 1 tote and end in Auto Zone",
                new AutonStack1Tote());
        autonChooser.addDefault("3 - Stack 2 totes and end in Auto Zone",
                new AutonStack2Totes());
        autonChooser.addDefault("4 - Stack 3 Totes and end in Auto Zone",
                new AutonStack1Tote());
        autonChooser.addDefault("5 - Stack 1 tote and grab 1 container",
                new AutonStack1ToteGrab1Container());
        autonChooser.addDefault("6 - Stack 2 totes and grab 1 container",
                new AutonStack2TotesGrab1Container());
        autonChooser.addDefault("7 - Stack 3 totes and grab 1 container",
                new AutonStack3TotesGrab1Container());
        // command

        SmartDashboard.putData("Autonomous Routine", autonChooser);
    }

    public void makeDriveChooser() {
        driveChooser = new SendableChooser();

        driveChooser.addDefault("Arcade with Sniper Mode",
                new ArcadeDriveWithSticks());
        driveChooser.addDefault("Tank Drive", new TankDriveWithSticks());
        driveChooser.addDefault("Arcade with Squared Inputs",
                new ArcadeDriveSquaredInputs());
        driveChooser.addDefault("Tank Drive for Testing",
                new TankDriveForTesting());

        SmartDashboard.putData("Drive Style", driveChooser);
    }

    private void smartDashboardUpdate() {
        SmartDashboard.putNumber("Left Drive Talon",
                RobotMap.getLeftTalonSpeed());
        SmartDashboard.putNumber("Right Drive Talon",
                RobotMap.getRightTalonSpeed());
        SmartDashboard.putNumber("Left Drive Encoder",
                RobotMap.getLeftEncoderSpeed());
        SmartDashboard.putNumber("Right Drive Encoder",
                RobotMap.getRightEncoderSpeed());
        SmartDashboard.putBoolean("Container Lift at Top",
                RobotMap.getTopContainerLiftSwitch());
        SmartDashboard.putBoolean("Container Lift at Bottom",
                RobotMap.getBottomContainerLiftSwitch());
        SmartDashboard.putBoolean("Container Lift Brake",
                Robot.containerElevator.getBrake());
        SmartDashboard.putBoolean("Tote Lift Brake",
                Robot.toteElevator.getBrake());
        SmartDashboard.putNumber("Tote Lift Encoder Distance",
                RobotMap.getToteElevatorEncoder());
        SmartDashboard.putBoolean("Tote Lift at Top",
                RobotMap.getTopToteLiftSwitch());
        SmartDashboard.putBoolean("Tote Lift at Bottom",
                RobotMap.getBottomToteLiftSwitch());
    }
}
