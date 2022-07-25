package com.mj.testcases;

import com.mj.base.BaseTest;
import com.mj.util.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustTest extends BaseTest {

    @Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
    public void addCustTest(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {
        click("addCust");
        type("fName",firstName);
        type("lName",lastName);
        //driver.findElement(By.xpath(or.getProperty("lName"))).sendKeys(lastName);
        driver.findElement(By.xpath(or.getProperty("pCode"))).sendKeys(postCode);
        driver.findElement(By.xpath(or.getProperty("add"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(alert.getText().contains(alerttext));

        Thread.sleep(2000);
        alert.accept();
    }



}
