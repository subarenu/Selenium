package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class SeliniumTest {

    WebDriver driver;
    String baseURL = "https://www.makemytrip.com/flights/";

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\testing\\src\\main\\resources\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEachTest(){
        driver = new ChromeDriver();
    }

    @Test
    public void testMethod() throws InterruptedException {
        driver.get(baseURL);
        driver.manage().window().maximize();
     //   driver.findElement(By.id("fromCity")).clear();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='header_tab_flights']")).click();
       /* WebElement element1 = driver.findElement(By.id("fromCity"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element1));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='From']"));
        element2.sendKeys("Bangalore");
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.attributeContains(element2,"value","Bangalore"));
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//p[contains(text(),'Bangalore, India')]")).click();
        WebElement element = driver.findElement(By.id("toCity"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        WebElement element3 = driver.findElement(By.xpath("//input[@placeholder='To']"));
        element3.sendKeys("Delhi");
        wait.until(ExpectedConditions.attributeContains(element3,"value","Delhi"));
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Keys.ENTER);
       driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox dates inactiveWidget')]")).click();
        Calendar calender = Calendar.getInstance(TimeZone.getDefault());
        int todayInt = calender.get(Calendar.DAY_OF_MONTH)+1;
        String nextDay = Integer.toString(todayInt);
        List<WebElement> webelements = driver.findElements(By.xpath("//div[@class='DayPicker-Months']//descendant::div[1]//descendant::div[@class='DayPicker-Body']//descendant::div[starts-with(@class,'DayPicker-Day')]"));
        for (int i =0;i<webelements.size();i++){
            String date = webelements.get(i).getText();
            if(date.equals(nextDay)){
                webelements.get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox flightTravllers inactiveWidget')]")).click();
        driver.findElement(By.xpath("//div[@class='fsw_inner interNational']//ul[1]/li[2]")).click();
        driver.findElement(By.xpath("//div[@class='widgetSection appendBottom40']//ul[2]/li[3]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'APPLY')]")).click();
        driver.findElement(By.xpath("//label[@for='travelFor']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'Work')]")).click();
        //driver.findElement(By.xpath("//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")).click(); */
       Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")).click();
        String searchResultTitle = driver.getTitle();
        Assertions.assertEquals("Makemytrip",searchResultTitle);

        List<WebElement> actualPrices = driver.findElements(By.xpath("//div[@id='left-side--wrapper']//div[@class='fli-intl-lhs pull-left']//span[@class='actual-price']"));
        List<Integer> prices = new ArrayList<>();
        List<Integer> sortedPrices = new ArrayList<>();
        actualPrices.forEach(i -> prices.add(Integer.parseInt(i.getText().replaceAll("[^0-9]","").trim())));
        sortedPrices.addAll(prices);
        Collections.sort(sortedPrices,Collections.reverseOrder());
        Assertions.assertEquals(sortedPrices,prices);
        System.out.println("Prices are "+prices);
        System.out.println("Prices sorted by asc are "+sortedPrices);

        Actions action = new Actions(driver);
    }
}
