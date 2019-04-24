package WebDriverProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public  static WebDriver driver;
    public static Properties prop;
    public static void loadProperties(){
    try{
        prop = new Properties();
        FileInputStream file = new FileInputStream("D:\\testing\\src\\test\\java\\Config\\configuration.properties");
        prop.load(file);
    }catch (IOException e){
        e.getMessage();
    }

    }

    public static void webDriverInitialization(){
        System.setProperty("webdriver.chrome.driver","D:\\testing\\src\\test\\java\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void getUrl(){
        driver.get(prop.getProperty("Url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


}


