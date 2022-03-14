package qa;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public RemoteWebDriver driver;
    public WebDriverWait wait;
    public BasePage(RemoteWebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void waitForElementToAppear(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public void waitForElementToClickable(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToDisappear(By locator)
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitForTextToDisappear(By locator,String text)
    {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator,text)));
    }
}
