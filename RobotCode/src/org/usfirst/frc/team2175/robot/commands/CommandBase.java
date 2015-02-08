package org.usfirst.frc.team2175.robot.commands;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
    protected final Logger log = Logger.getLogger(getClass().getName());

    @Override
    protected void initialize() {
        log.info("Starting command");
    }

    @Override
    protected void end() {
        log.info("Ending command");
    }
}
