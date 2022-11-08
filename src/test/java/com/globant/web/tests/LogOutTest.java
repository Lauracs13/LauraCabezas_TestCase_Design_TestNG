package com.globant.web.tests;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class LogOutTest {
    Logger log = Logger.getLogger(String.valueOf(LogOutTest.class));

    @BeforeClass
    public void openWebBrowser() {
        log.info("Open the web browser");
    }

    @BeforeClass
    public void searchTheUrl() {
        log.info("Enter the URL https://www.espnqa.com/?_adbock=true&src=com in the browsers search box ");
    }

    @BeforeMethod
    public void logInUser() {
        log.info("Log in the user");
    }

    @Test
    public void LogOut() {
        log.info("Click on the icon upper right");
        log.info("Click on the Log Out option");
    }

    @AfterClass
    public void closeBrowser() {
        log.info("Close the browser");
    }
}
