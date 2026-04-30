package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

            File reportFile = new File(reportPath);
            reportFile.getParentFile().mkdirs();

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setReportName("SweetCart Report");
            spark.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            System.out.println("Extent Report Path: " + reportPath);
        }

        return extent;
    }
}