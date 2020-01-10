package utils;

import helpers.Directory;
import managers.ConfigBoss;
import managers.DriverBoss;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import pageObjects.*;
import reports.CustomReporter;

import java.io.File;
import java.io.IOException;

/**
 * Created by kamil.czerwonka on 08.12.2019.
 */
public class BaseTest {

    public HomePage homePage = new HomePage(DriverBoss.getInstance());
    public AuthenticationPage authenticationPage = new AuthenticationPage(DriverBoss.getInstance());
    public MyAccountPage myAccountPage = new MyAccountPage(DriverBoss.getInstance());
    public PrintedSummerDressPage printedSummerDressPage = new PrintedSummerDressPage(DriverBoss.getInstance());
    public ResultSearchPage resultSearchPage = new ResultSearchPage((DriverBoss.getInstance()));

    @Before
    public void setUp() {
        clearReportDir();
        CustomReporter.setUpReporter("My_Test");
        CustomReporter.myTest = CustomReporter.report.createTest("Test");
        CustomReporter.info("Open Browser");
        clearLog();
        DriverBoss.getInstance().get(ConfigBoss.url);
    }

    @After
    public void closeDriver(){
        DriverBoss.kill();
        CustomReporter.report.flush();
    }

    public static void clearReportDir(){
        File reportDir = new File(Directory.PROJECT_DIR + "\\report");
        if (!reportDir.exists()){
            reportDir.mkdir();
        }
    }

    private static void clearLog(){
        CustomReporter.info("Clear Current Logs In Project");
        try {
            File screenshotDir = new File(Directory.PROJECT_DIR + "\\report\\failedTestsScreenshots");
            FileUtils.cleanDirectory(new File(Directory.PROJECT_DIR + "\\report"));
            if(!screenshotDir.exists()){
                screenshotDir.mkdir();
            }
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

}
