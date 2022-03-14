package qa;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.sources.ReportsUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {
    private static RemoteWebDriver driver;
    public static ExtentReports report;
    public static ExtentTest child;

    public RemoteWebDriver getDriver() {
        return driver;
    }


    @BeforeSuite(alwaysRun = true)
    @Parameters({"url","reportName","env"})
    public void inIt(String url,String reportName,String env)
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/CSC/Desktop/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
        report = ReportsUtil.createInstance(reportName);
        report.setSystemInfo("User","Faraz");
        report.setSystemInfo("Environment",env);
       // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
//    @BeforeClass
//    public void launchBrowser()
//    {
//        System.out.println("This is a before class OPEN BROWSER");
//    }
//    @BeforeMethod
//    public void enterSpecificPage()
//    {
//
//        System.out.println("This is a before method Enter Specific Page");
//    }
    @AfterMethod
    public void afterMethod(ITestResult result)
    {
        try{
            if(result.getStatus()== ITestResult.FAILURE)
            {
                long duration = result.getStartMillis();
                child.log(Status.FAIL,"Run time for the Test: "+(result.getEndMillis()-duration)+" MiliSeconds");
                child.log(Status.FAIL,"Test Failed: "+result.getName());
                child.log(Status.FAIL,""+result.getThrowable());
                child.addScreenCaptureFromPath(getScreenshot(driver,result.getName()));

            }else if(result.getStatus()== ITestResult.SUCCESS){
                long duration = result.getStartMillis();
                child.log(Status.PASS,"Run time for the Test: "+(result.getEndMillis()-duration)+" MiliSeconds");
            }else if(result.getStatus()== ITestResult.SKIP){

            }

        }catch (IOException e)
        {

        }
        report.flush();
        System.out.println("This is a After method log out");
    }
//    @AfterClass
//    public void closeBrowser()
//    {
//        System.out.println("This is a After Class CLOSE BROWSER");
//    }

//    @AfterTest
//    public void afterTestMethod()
//    {
//        System.out.println("This is a After Test flush report");
//    }
    @AfterSuite
    public void close(){
        System.out.println("This is in After SUIT");
        driver.quit();

    }
    public static String getScreenshot(RemoteWebDriver driver,String name) throws IOException
    {
        String dateString = (new SimpleDateFormat("yyyyddMM-hhmmss")).format(new Date());
        String destination;
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        destination = System.getProperty("user.dir")+"\\failedTestScreenshots\\"+name+"_"+dateString+".jpg";
        FileUtils.copyFile(src,new File(destination));

        return destination;
    }


}
