package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.single.DriveInches;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonMinus1Test extends CommandGroup {

    public AutonMinus1Test() {

        addSequential(new DriveInches(18));

        // DRIVE A SQUARE
        // addSequential(new DriveInches(36));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(90, true));
        // addSequential(new WaitCommand(1));
        // addSequential(new DriveInches(36));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(90, true));
        // addSequential(new WaitCommand(1));
        // addSequential(new DriveInches(36));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(90, true));
        // addSequential(new WaitCommand(1));
        // addSequential(new DriveInches(36));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(90, true));

        // DRIVE FORWARD, TURN 180, DRIVE BACK, TURN 180
        // addSequential(new DriveInches(72));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(180));
        // addSequential(new WaitCommand(1));
        // addSequential(new DriveInches(72));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(0));
        // addSequential(new WaitCommand(1));

        // addSequential(new TurnDegrees(90, false));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(180, false));
        // addSequential(new WaitCommand(1));
        // addSequential(new TurnDegrees(360, false));

        // TEST ROBONAUTS AUTO
        // addSequential(new TurnDegrees(-30));
        // addSequential(new DriveInches(8));
        // addSequential(new DriveInches(-8));
        // addSequential(new TurnDegrees(0));
        // addSequential(new DriveInches(85));
        // addSequential(new TurnDegrees(-30));
        // addSequential(new DriveInches(8));
        // addSequential(new DriveInches(-8));
        // addSequential(new TurnDegrees(0));
        // addSequential(new DriveInches(85));
        // addSequential(new TurnDegrees(-30));
        // addSequential(new DriveInches(8));
        // addSequential(new DriveInches(-8));
        // addSequential(new TurnDegrees(45));
        // addSequential(new DriveInches(102));
        // addSequential(new DriveInches(-60));
    }
}
