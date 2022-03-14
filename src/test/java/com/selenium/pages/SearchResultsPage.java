package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.BasePage;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(RemoteWebDriver driver)
    {
        super(driver);
    }
    String firstSearchResult ="//div[@id='search']/div/div/div[1]//div[@class='yuRUbf']/a/h3";
    //Locator firstSearchResult = driver.findElement(By.xpath("//div[@id='search']/div/div/div[1]//div[@class='yuRUbf']/a/h3"));
    public String verifyFirstResult()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstSearchResult)));
        String text = driver.findElement(By.xpath(firstSearchResult)).getText();
        return text;
    }
}
