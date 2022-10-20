package Repoting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class ExtentReporting {
    public static ExtentReports extent;
    public static ExtentTest parentTest;
    public ExtentReporting(){
    }
    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html")
         .viewConfigurer()
                .viewOrder()
                .as(new ViewName[] {
                        ViewName.DASHBOARD,
                        ViewName.TEST,
                        ViewName.AUTHOR,
                        ViewName.DEVICE,
                        ViewName.EXCEPTION,
                        ViewName.LOG
                })
                .apply();
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Automation Report");
    }
    public static void flushReport(){
        extent.flush();
        try {
            Desktop.getDesktop().browse(new File("target/spark.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extent.createTest(testCaseName)
                .assignAuthor("Almas")
                .assignCategory("Regression")
                .assignDevice("Chrome"));
    }
}
