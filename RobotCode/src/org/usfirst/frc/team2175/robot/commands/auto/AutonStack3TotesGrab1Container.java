package org.usfirst.frc.team2175.robot.commands.auto;

import org.usfirst.frc.team2175.robot.commands.groups.IntakeTote;
import org.usfirst.frc.team2175.robot.commands.groups.StackTote;
import org.usfirst.frc.team2175.robot.commands.single.CloseContainerIntake;
import org.usfirst.frc.team2175.robot.commands.single.CloseToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.DriveInches;
import org.usfirst.frc.team2175.robot.commands.single.MoveContainerElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.MoveToteElevatorWithInputs;
import org.usfirst.frc.team2175.robot.commands.single.OpenToteIntake;
import org.usfirst.frc.team2175.robot.commands.single.RunLeftToteIntakeWheels;
import org.usfirst.frc.team2175.robot.commands.single.RunRightToteIntakeWheels;
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
        addSequential(new WaitCommand(.25));
        addParallel(new MoveContainerElevatorWithInputs(1), 1.5);
        addParallel(new MoveToteElevatorWithInputs(.5), 1.7);
        addSequential(new WaitCommand(.5));
        addSequential(new TurnDegrees(-165));

        // Drive for second tote
        addSequential(new DriveInches(18), .5);

        // Intake it
        addSequential(new CloseToteIntake());
        addParallel(new RunRightToteIntakeWheels(), 1);
        addParallel(new DriveInches(12), 0.5);
        addSequential(new RunLeftToteIntakeWheels(), 1);
        
        addSequential(new TurnDegrees(-195), 1.5);
        addParallel(new DriveInches(68), 2);
        addSequential(new OpenToteIntake());
        addParallel(new StackTote());

        // Good to here
        addSequential(new TurnDegrees(-147),1.5);
        
        addSequential(new WaitCommand(.5));
        addSequential(new DriveInches(24),2);
        addSequential(new CloseToteIntake());
        addSequential(new RunRightToteIntakeWheels(),1);
        addSequential(new RunLeftToteIntakeWheels(),1);
        addSequential(new OpenToteIntake());
        addSequential(new MoveToteElevatorWithInputs(-.8), 3);
        addSequential(new MoveToteElevatorWithInputs(.4),2);
        addSequential(new TurnDegrees(-270),1.5);
        addSequential(new DriveInches(100),3);
        addSequential(new MoveToteElevatorWithInputs(.4),2);
        addSequential(new DriveInches(-100),2);
        		
    }
}
