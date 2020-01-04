package com.suba.packages.pages;

import com.suba.packages.webdriverprovider.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccessful extends BaseClass {

    @FindBy(xpath = "//b[contains(text(),'Note: Your user name is')]")
    WebElement text;

    public RegistrationSuccessful() {
        PageFactory.initElements(driver, this);
    }

    public String pageTitle() {
        String partialtext = text.getText();
        System.out.println(partialtext);
        return partialtext;
    }
}
