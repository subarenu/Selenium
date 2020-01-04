package com.suba.packages.pages;

import com.suba.packages.webdriverprovider.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BaseClass {
    @FindBy(xpath = "//a[contains(text(),'REGISTER')]")
    WebElement register;

    public Registration() {
        PageFactory.initElements(driver, this);
    }

    public String pagetitle(){
        String title = driver.getTitle();
        return title;
    }

    public RegistrationPage registrationClick(){
        register.click();
        return new RegistrationPage();
    }
}
