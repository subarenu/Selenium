package Pages;

import WebDriverProvider.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOn extends BaseClass {
    @FindBy(xpath = "//input[@name='userName']")
    WebElement user;
    @FindBy(xpath = "//input[@name='password']")
    WebElement pass;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement login;

    public SignOn(){
        PageFactory.initElements(driver,this);
    }

    public String pageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public Flightfinder Login(){
        user.sendKeys(prop.getProperty("username"));
        pass.sendKeys(prop.getProperty("password"));
        login.click();
        return new Flightfinder();
    }
}
