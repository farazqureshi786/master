package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.BaseTest;

public class FirstTest extends BaseTest {

    @Test
    @Parameters("url")
    public void firstTest(String url)
    {
        child = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("SUM");
        int a = 10;
        int b = 20;
        int sum = a+b;
        Assert.assertEquals(sum,30,"The test sum ");
        System.out.println("Parameter: "+url);
    }
    @Test
    @Parameters("browser")
    public void secondTest(String browser)
    {
        child = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("SUBTRACT");
        int a = 10;
        int b = 20;
        int sub = a-b;
        Assert.assertEquals(sub ,-10,"The test sub");
        System.out.println("Parameter: "+browser);
    }
    @Test
    public void thirdTest()
    {
        child = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("MULTIPLY");
        int a = 10;
        int b = 20;
        int mul = a*b;
        Assert.assertEquals(mul,200,"The test multiply");
    }
    @Test
    public void fourthTest()
    {
        child = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("DIVIDE");
        int a = 10;
        int b = 20;
        int divide = b/a;
        Assert.assertEquals(divide,2,"The test divide");
    }
    @Test
    public void fifthTest()
    {
        child = report.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("REMAINDER");
        int a = 10;
        int b = 3;
        int remainder = a%b;
        Assert.assertEquals(remainder,1,"The test remainder");
    }
}
