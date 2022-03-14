package com.selenium.tests;

import com.aventstack.extentreports.Status;
import com.selenium.pages.SearchPage;
import com.selenium.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import qa.BaseTest;

public class SeleniumTest extends BaseTest {

    @Test
    public void googleSearch()
    {
        try {
                child = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
                SearchPage searchPage = new SearchPage(getDriver());
                Thread.sleep(3000);
                String searchText ="First Selenium run";
                child.log(Status.INFO,"Searching for the string \""+searchText+"\"");
                String searchResults = searchPage.performSearch(searchText);
                Assert.assertEquals(searchResults, "First Selenium run - Google Search", "Asserting title");
        }catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
            e.getStackTrace();
            child.fail(e);
        }
    }
    @Test
    public void verifySearchResults()
    {
        try {
            child = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
            SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
            String firstResult = searchResultsPage.verifyFirstResult();
            child.log(Status.INFO,"Returned Result \""+firstResult+"\"");
            Assert.assertEquals(firstResult,"How to  your first Selenium test script - BrowserStack","Verifying Search Results");

        }catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
            e.getStackTrace();
            child.fail(e);
        }
    }
}
