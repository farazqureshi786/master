package com.selenium.sources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Locale;

public class ReportsUtil {
    private static final Logger log = LoggerFactory.getLogger(ReportsUtil.class);
    private static String platform;
    private static ExtentReports extentReports;
    private static String reportFileName;
    private static String macPath = System.getProperty("user.dir")+"/TestReport";
    private static String windowsPath = System.getProperty("user.dir")+"\\TestReport";
    private static String linuxPath = System.getProperty("user.dir")+"/TestReport";
    private static String reportFileLocation;
    public static ExtentReports createInstance(String fileName)
    {
        platform = getCurrentPlatForm();
        reportFileName = fileName+".html";
        fileName = getReportFileLocation(platform);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setReportName(fileName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        return extentReports;
    }
    public static String getReportFileLocation(String platform)
    {
        reportFileLocation = null;
        switch (platform){
            case "MAC":
                reportFileLocation = macPath+"/"+reportFileName;
                createReportPath(reportFileLocation);
                log.info("ExtentReport path for mac: {}",macPath);
                break;
            case "WINDOWS":
                reportFileLocation = windowsPath+"\\"+reportFileName;
                createReportPath(reportFileLocation);
                log.info("ExtentReport path for windows: {}",windowsPath);
                break;
            case "LINUX":
                reportFileLocation = linuxPath+"/"+reportFileName;
                createReportPath(reportFileLocation);
                log.info("ExtentReport path for mac: {}",linuxPath);
                break;
            default:
                log.error("ExtentReports path has not been set! there is a problem");
        }
        return reportFileLocation;
    }
    public static void createReportPath(String path)
    {
        File testDirectory = new File(path);
        try{
            if(!testDirectory.exists())
        {
            if(testDirectory.createNewFile())
            {
                log.info("Directory {} is created!",path);
            }else
            {
                log.info("Failed to create Directory: {}",path);
            }
        }else
        {
            log.info("Directory {} already exists!",path);
        }
        }catch(Exception e)
        {
            log.error(e.getLocalizedMessage());
        }
    }
    public static String getCurrentPlatForm()
    {
        if(platform==null)
        {
            String operatingSystem = System.getProperty("os.name").toLowerCase(Locale.ROOT);
            if(operatingSystem.contains("win"))
            {
                platform = "WINDOWS";
            }else if(operatingSystem.contains("nix")||operatingSystem.contains("nux")||operatingSystem.contains("aix"))
            {
                platform = "LINUX";
            }else if(operatingSystem.contains("mac"))
            {
                platform = "MAC";
            }
        }
        return platform;

    }


}
