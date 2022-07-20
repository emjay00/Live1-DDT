package com.mj.testcases;

import com.mj.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class AddCustTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void addCust(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {

        driver.findElement(By.xpath(or.getProperty("addCust"))).click();
        driver.findElement(By.xpath(or.getProperty("fName"))).sendKeys(firstName);
        driver.findElement(By.xpath(or.getProperty("lName"))).sendKeys(lastName);
        driver.findElement(By.xpath(or.getProperty("pCode"))).sendKeys(postCode);
        driver.findElement(By.xpath(or.getProperty("add"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(alert.getText().contains(alerttext));
        alert.accept();
        Thread.sleep(3000);

    }

    @DataProvider
    public Object[][] getData() {

        String sheetName = "AddCustTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);
        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;


    }
}
