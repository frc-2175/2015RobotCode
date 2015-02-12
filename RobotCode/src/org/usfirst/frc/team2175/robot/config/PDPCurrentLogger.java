package org.usfirst.frc.team2175.robot.config;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc.team2175.robot.RobotMap;

public class PDPCurrentLogger {
    private final Logger log = Logger.getLogger(getClass().getName());

    // Use Robot location for the actual robot and test location for the test
    public static final String CSV_OUT_ROBOT_LOCATION = "/home/lvuser/pdplog.csv";
    public static final String CSV_OUT_TEST_LOCATION = "build/testPDPlog.csv";

    private String logOutFileToUse = CSV_OUT_ROBOT_LOCATION;
    private OutputStreamWriter out;

    public void initPDPLogging() {

        try {
            out = new FileWriter(logOutFileToUse);
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, "Failed to open PDP log file at "
                    + logOutFileToUse + "!", e);

        } catch (IOException e) {
            log.log(Level.SEVERE, "Failed to open PDP log file at "
                    + logOutFileToUse + "!", e);

        }
        try {
            out.write("Time, Port 0 current, Port 1 current, Port 2 current, Port 3 current, Port 4 current, Port 5 current, Port 6 current, Port 7 current, Port 8 current, Port 9 current, Port 10 current, Port 11 current, Port 12 current, Port 13 current, Port 14 current, Port 15 current \n");
        } catch (IOException e) {
            log.log(Level.SEVERE, "could not write to file!", e);

        }
    }

    public void logPDPValues() {
        if (out != null) {
            // start with a timestamp
            try {
                out.write(edu.wpi.first.wpilibj.Timer.getFPGATimestamp() + ", ");
            } catch (IOException e) {
                log.log(Level.SEVERE, "could not write to file", e);
            }
            // log the values
            for (int i = 0; i <= 15; i++) {
                try {
                    out.write(RobotMap.pdp.getCurrent(i) + ", ");
                } catch (IOException e) {
                    log.log(Level.SEVERE, "could not write to file", e);
                }
            }
            // newline!
            try {
                out.write("\n");
            } catch (IOException e) {
                log.log(Level.SEVERE, "could not write to file!", e);
            }
        }

    }

    public void endPDPLogging() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                log.log(Level.SEVERE, "No writer to close!", e);

            }
        }
    }

    public void setLogOutFileToUse(String filepath) {
        logOutFileToUse = filepath;
    }

    public String getLogOutFileToUse() {
        return logOutFileToUse;
    }

}
