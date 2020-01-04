package com.suba.packages.pages;

import com.suba.packages.webdriverprovider.BaseClass;

public class SelectFlight extends BaseClass {

    public String pageTitle(){
        String title = driver.getTitle();
        return title;
    }
}
