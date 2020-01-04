package com.suba.packages.utilities;

import com.suba.packages.webdriverprovider.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonClass extends BaseClass {
    Select sel;

    public void selectValuesInDropdownByString(WebElement element, String by,String value){
        sel = new Select(element);
        if (by.equals("ByValue")){
            sel.selectByValue(value);
        }else if(by.equals("ByDisplayName")){
            sel.selectByVisibleText(value);
        }
    }

    public void selectValuesInDropdownByIndex (WebElement element, int value){
        sel = new Select(element);
        sel.selectByIndex(value);
    }

    public String getSelectedValuesFromDropdown(WebElement element){
        sel = new Select(element);
        String selectedValue = sel.getFirstSelectedOption().getText();
        return selectedValue;
    }
}
