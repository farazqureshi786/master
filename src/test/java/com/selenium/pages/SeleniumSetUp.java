package com.selenium.pages;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumSetUp {
    public static void main(String args[])
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/CSC/Desktop/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Page Loaded: "+title);
        driver.close();

    }
}
