package com.mj.testcases;

import com.mj.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BmLoginTest extends BaseTest {
    @Test
    void loginasBM() throws InterruptedException {
        log.debug("Inside login test");
        driver.findElement(By.xpath(or.getProperty("bmLogin"))).click();
        Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("addCust"))),"Login not successful");
        Thread.sleep(3000);
        log.debug("Login successful");
    }
}
