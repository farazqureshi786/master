package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.BasePage;

import java.time.Duration;


public class SearchPage extends BasePage {
    public SearchPage(RemoteWebDriver driver)
    {
        super(driver);
    }
    WebElement textBox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi' and @type='text']"));
    WebElement searchButton = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search' and @name='btnK']"));
    public String performSearch(String searchText)
    {
        try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        textBox.sendKeys(searchText+ Keys.ENTER);
        //searchButton.click();
        return driver.getTitle();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
