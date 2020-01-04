package com.suba.packages.webdriverprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public  static WebDriver driver;
    public static Properties prop;
    public static void loadProperties(){
    try{
        prop = new Properties();
        FileInputStream file = new FileInputStream(ClassLoader.getSystemResource("config/configuration.properties").getPath());
        prop.load(file);
    }catch (IOException e){
        e.getMessage();
    }

    }

    public static void webDriverInitialization(){
        System.setProperty("webdriver.chrome.driver",ClassLoader.getSystemResource("drivers/chromedriver.exe").getPath());
        driver = new ChromeDriver();
    }

    public static void getUrl(){
        driver.get(prop.getProperty("Url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


}


