package com.mj.testcases;

import com.mj.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BmLoginTest extends BaseTest {
    @Test
    void loginasBM() throws InterruptedException {
        log.debug("Inside login test");
        driver.findElement(By.xpath(or.getProperty("bmLogin"))).click();
        Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("addCust"))),"Login not successful");
        log.debug("Login successful");
        Reporter.log("Test execution done");
        //Assert.fail("login not successful");
    }
}
