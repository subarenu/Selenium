package Pages;

import WebDriverProvider.BaseClass;

public class SelectFlight extends BaseClass {

    public String pageTitle(){
        String title = driver.getTitle();
        return title;
    }
}
