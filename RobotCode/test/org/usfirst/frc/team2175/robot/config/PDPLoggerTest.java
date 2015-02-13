package org.usfirst.frc.team2175.robot.config;

import java.io.IOException;

import org.junit.Test;
import org.usfirst.frc.team2175.robot.TestBase;

public class PDPLoggerTest extends TestBase {

    @Test
    public void testInitPDPLogger() throws IOException {
        PDPCurrentLogger testPDPLogger = new PDPCurrentLogger();
        testPDPLogger
                .setLogOutFileToUse(PDPCurrentLogger.CSV_OUT_TEST_LOCATION);
        testPDPLogger.initPDPLogging();
        System.out.println("Logging initialized...");
        testPDPLogger.writeOtherValuesToPDPLog("Test running");
        testPDPLogger.endPDPLogging();
        System.out.println("Logging ended.");
    }
}