package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import helpers.Directory;
import managers.ConfigBoss;
import managers.DriverBoss;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kamil.czerwonka on 08.12.2019.
 */
public class CustomReporter {

    public static ExtentTest myTest;
    private static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports report;

    public static void setUpReporter(String suiteName) {
        report = new ExtentReports();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String timestamp = dateFormat.format(new Date());

        extentHtmlReporter = new ExtentHtmlReporter(Directory.PROJECT_DIR
                + "/report/" + suiteName + ".html");

        extentHtmlReporter.loadXMLConfig(
                new File(CustomReporter.class
                        .getClassLoader()
                        .getResource("reportConfig.xml")
                        .getFile()));
        extentHtmlReporter.setAppendExisting(false);
        extentHtmlReporter.start();
        report.attachReporter(extentHtmlReporter);
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Website", ConfigBoss.url);
        report.setSystemInfo("Report Name", suiteName);

    }

    public static void pass(String message){myTest.pass(message);}
    public static void info(String message){myTest.info(message);}
    public static void skip(String message){myTest.fail(message);}

    public static void fail(String message){
        try {
            if (DriverBoss.driver != null){
                File e = (File)((TakesScreenshot)DriverBoss.getInstance()).getScreenshotAs(OutputType.FILE);
                String dateName = (new SimpleDateFormat("yyyyMMddhhmmss")).format(new Date());
                String destination = Directory.PROJECT_DIR + String.format("\\report\\failTestsScreenshots\\%s.jpg", new Object[]{dateName});
                FileCopyUtils.copy(e, new File(destination));
                myTest.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(destination.replace(Directory.PROJECT_DIR + "\\report\\", "")).build());
            } else {
                myTest.fail(message);
            }
        } catch (Exception var4) {
            Assert.fail(var4.getCause().getMessage());
        }
    }

}
