package com.mj.testcases;

import com.mj.base.BaseTest;
import com.mj.util.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseTest {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void openAccountTest(String customer, String currency) throws InterruptedException {
       //driver.findElement(By.xpath(or.getProperty("openaccount"))).click();
        click("openaccount");
        //System.out.println(customer);
        select("cust", customer);
        //System.out.println(currency);
        select("currency", currency);
        click("process");
        Thread.sleep(1000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }


}
