package com.mj.util;

import com.mj.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

public class TestUtil extends BaseTest {
    public static String screenshotPath;
    public static String screenshotName;

    public static void getScreenshot() throws IOException {
        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
        screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);
        FileHandler.copy(source, destination);
    }

    @DataProvider(name = "dp")
    public Object[][] getData(Method m) {
        String sheetName = m.getName();
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

//    public static boolean isRunnable(String testName, ExcelReader excel) {
//        String sheetName = "test_suite";
//        int rows = excel.getRowCount(sheetName);
//        for (int rNum = 2; rNum <= rows; rows++) {
//            String testCase = excel.getCellData(sheetName, "Tcno", rNum);
//            if (testCase.equalsIgnoreCase(testName)) {
//                String runmode = excel.getCellData(sheetName, "runmode", rNum);
//                if (runmode.equalsIgnoreCase("y"))
//                    return true;
//                else
//                    return false;
//
//            }
//
//        }
//        return false;
//    }
}
