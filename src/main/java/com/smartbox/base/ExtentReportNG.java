package com.smartbox.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.smartbox.utils.PropertiesOperations;

import java.text.SimpleDateFormat;
import java.util.Date;

/**@author Amarnath
 * ExtentReportNG class used to configure report profile and storing generated report a specific file.
 */

public class ExtentReportNG {

    static ExtentReports extent;

    public static ExtentReports setupExtentReport() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir")+
                "/reports/ExecutionReport_"+actualDate+".html";

        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("SMARTBOX");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("Smartbox Tests");

        extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValue("url"));
        extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValue("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

        return extent;
    }
}
