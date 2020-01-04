package com.suba.packages.testPackage;

import com.suba.packages.pages.Flightfinder;
import com.suba.packages.pages.Registration;
import com.suba.packages.pages.RegistrationPage;
import com.suba.packages.pages.RegistrationSuccessful;
import com.suba.packages.pages.SignOn;
import com.suba.packages.webdriverprovider.BaseClass;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTest extends BaseClass {

    Registration reg;
    SignOn signon;

    @BeforeEach
    public void setUp() {
        loadProperties();
        webDriverInitialization();
        reg = new Registration();
        signon = new SignOn();
    }


    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test()
    @Order(1)
    public void verifyRegistration() {
        getUrl();
        String title = reg.pagetitle();
        Assertions.assertEquals("Welcome: Mercury Tours", title);
        RegistrationPage regPage = reg.registrationClick();
        Assertions.assertEquals("Register: Mercury Tours", regPage.pagetitle());
        RegistrationSuccessful success = regPage.registered();
        Assertions.assertEquals("Note: Your user name is " + prop.getProperty("username") + ".", success.pageTitle());
    }

    @Test
    @Order(2)
    public void verifySignIn() {
        getUrl();
        String title = signon.pageTitle();
        Assertions.assertEquals("Welcome: Mercury Tours", title);
        Flightfinder finder = signon.Login();
        Assertions.assertEquals("Find a Flight: Mercury Tours:", finder.pageTitle());

    }

}
