package com.suba.packages.testPackage;

import com.suba.packages.pages.Flightfinder;
import com.suba.packages.pages.Registration;
import com.suba.packages.pages.SelectFlight;
import com.suba.packages.pages.SignOn;
import com.suba.packages.webdriverprovider.BaseClass;
import org.junit.jupiter.api.*;

public class FlightBookingTest extends BaseClass {

    private Registration reg;
    private SignOn signon;
    private Flightfinder finder;
    private SelectFlight selectFlight;

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

    public Flightfinder verifySignIn() {
        getUrl();
        String title = signon.pageTitle();
        Assertions.assertEquals("Welcome: Mercury Tours", title);
        finder = signon.Login();
        Assertions.assertEquals("Find a Flight: Mercury Tours:", finder.pageTitle());
        return finder;
    }

    @Test
    public void bookFlight() {
        verifySignIn();
        Boolean selected = finder.selectTripType();
        Assertions.assertTrue(selected);
        String valueDisplay = finder.selectPassengers(2).trim();
        Assertions.assertEquals("3", valueDisplay);
        String fromValueDisplay = finder.selectFrom("London");
        Assertions.assertEquals("London", fromValueDisplay);
        String fromMonthDisplay = finder.selectFromMonth("April");
        Assertions.assertEquals("April", fromMonthDisplay);
        String fromDateDisplay = finder.selectFromDate("20");
        Assertions.assertEquals("20", fromDateDisplay);
        String arrivalDisplay = finder.selectArrival("Paris");
        Assertions.assertEquals("Paris", arrivalDisplay);
        String arrivalMonthDisplay = finder.selectReturnMonth("May");
        Assertions.assertEquals("May", arrivalMonthDisplay);
        String arrivalDateDisplay = finder.selectReturnDate("30");
        Assertions.assertEquals("30", arrivalDateDisplay);
        String selectClassType = finder.selectClassType("First");
        Assertions.assertEquals("First", selectClassType);
        String selectAirlines = finder.selectAirline("Unified Airlines");
        Assertions.assertEquals("Unified Airlines", selectAirlines);
        selectFlight = finder.clickOnContinue();
        String selectFlightPageTitle = selectFlight.pageTitle();
        Assertions.assertEquals("Select a Flight: Mercury Tours", selectFlightPageTitle);
    }

}
