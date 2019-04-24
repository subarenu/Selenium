package Pages;

import WebDriverProvider.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass {
    @FindBy(xpath = "//input[@name='email']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement confirmpassword;

    @FindBy(xpath = "//input[@name='register']")
    WebElement submit;

    public RegistrationPage(){
        PageFactory.initElements(driver,this);
    }
    public String pagetitle(){
        String title = driver.getTitle();
        return title;
    }
    public RegistrationSuccessful registered(){
        username.sendKeys(prop.getProperty("username"));
        password.sendKeys(prop.getProperty("password"));
        confirmpassword.sendKeys(prop.getProperty("password"));
        submit.click();
        return new RegistrationSuccessful();
    }
}
