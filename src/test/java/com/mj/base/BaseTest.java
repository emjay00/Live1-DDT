package com.mj.base;

import com.mj.util.ExcelReader;
import jdk.dynalink.beans.StaticClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class BaseTest {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties or = new Properties();
    public static FileInputStream in;
    public static Logger log = Logger.getLogger(BaseTest.class.getName());
    public static ExcelReader excel = new ExcelReader((System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx"));

    public static WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws IOException {

        if (driver == null) {
            // org.apache.log4j.BasicConfigurator.configure(new NullAppender());
            in = new FileInputStream((System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties"));
            config.load(in);
            log.debug("Config file loaded");
            in = new FileInputStream((System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties"));
            or.load(in);
            log.debug("OR file loaded");
        }
        if (config.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (config.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.get(config.getProperty("testsiteurl"));
        log.debug("Navigated to page URL");
        driver.manage().window().maximize();
        //System.out.println(config.getProperty("implicit.wait"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void click(String locator) {
        driver.findElement(By.xpath(or.getProperty(locator))).click();
    }

    public void type(String locator, String value) {
        driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
    }

    static WebElement dropdown;

    public void select(String locator, String value) {
        driver.findElement(By.xpath(or.getProperty(locator)));
        Select select = new Select(driver.findElement(By.xpath(or.getProperty(locator))));
        select.selectByVisibleText(value);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        log.debug("Test execution complete");
    }
}
