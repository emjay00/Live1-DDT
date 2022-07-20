package com.mj.extras;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties config = new Properties();
        Properties or = new Properties();
        FileInputStream in = new FileInputStream((System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties"));
        config.load(in);

        in = new FileInputStream((System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties"));
        or.load(in);

        System.out.println(config.getProperty("browser"));

        //driver.findElement(By.xpath(or.getProperty("bmlogin"))).click();
        System.out.println(or.getProperty("bmLogin"));


    }
}
