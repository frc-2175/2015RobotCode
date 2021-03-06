package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.ArcadeDriveWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.CloseToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.OpenToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.RunLeftToteIntakeWheels;
import org.usfirst.frc.team2175.robot.commands.single.RunLeftToteIntakeWheelsBackwards;
import org.usfirst.frc.team2175.robot.commands.single.RunRightToteIntakeWheels;
import org.usfirst.frc.team2175.robot.commands.single.RunRightToteIntakeWheelsBackwards;
import org.usfirst.frc.team2175.robot.commands.single.TurnDegrees;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutonStack3TotesGrab1Container extends CommandGroup {

    public AutonStack3TotesGrab1Container() {
        /** TODO check all numbers and if they need to be negated */
        // Container, first tote, and turn
        addParallel(new CloseContainerIntake());
        addSequential(new IntakeTote());
        addSequential(new WaitCommand(0.25));
        addParallel(new MoveContainerElevatorWithInputs(1), 1.5);
        addParallel(new MoveToteElevatorWithInputs(.5), 1.7);
        addSequential(new WaitCommand(.1));
        addSequential(new TurnDegrees(-165));

        // Drive for second tote
        addSequential(new DriveInches(20), 1);

        // Intake it
        addSequential(new CloseToteIntake());
        addParallel(new RunRightToteIntakeWheels(), 1);
        addParallel(new DriveInches(12), 0.5);
        addSequential(new RunLeftToteIntakeWheels(), 1);
        
        addSequential(new TurnDegrees(-192), 1.5);
        addParallel(new OpenToteIntake());
        addParallel(new StackTote());
        addSequential(new DriveInches(71), 2);

        // Good to here
        addSequential(new TurnDegrees(-150),1.5);
        
        addSequential(new WaitCommand(.5));
        addSequential(new DriveInches(30),2);
        addSequential(new CloseToteIntake());
        addParallel(new RunRightToteIntakeWheels(),1);
        addParallel(new RunLeftToteIntakeWheels(),1);
        addSequential(new TurnDegrees(-270),1.5);
        addParallel(new MoveToteElevatorWithInputs(-.6),1);
        addSequential(new ArcadeDriveWithInputs(1,0),1);
        addSequential(new ArcadeDriveWithInputs(.5,0),.3);
        addSequential(new OpenToteIntake());
        addParallel(new RunRightToteIntakeWheelsBackwards(),1);
        addParallel(new RunLeftToteIntakeWheelsBackwards(),1);
        addSequential(new DriveInches(-75),2);
        		
    }
}
