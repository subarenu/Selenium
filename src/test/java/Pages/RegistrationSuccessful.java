package Pages;

import WebDriverProvider.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccessful extends BaseClass {

    @FindBy(xpath = "//b[contains(text(),'Note: Your user name is')]")
    WebElement text;

    public RegistrationSuccessful(){
        PageFactory.initElements(driver, this);
    }
    public String pageTitle(){
        String partialtext = text.getText();
        System.out.println(partialtext);
        return partialtext;
    }
}
