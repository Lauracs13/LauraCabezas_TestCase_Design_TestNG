package com.globant.web.tests;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class DeleteAccountTest {
    Logger log = Logger.getLogger(java.lang.String.valueOf(DeleteAccountTest.class));

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
        log.info("Click on the ESPN Profile option");
        log.info("Scroll down");
        log.info("Click on the Delete Account option");
        log.info("Click on the Yes, delete this account option");
    }

    @AfterClass
    public void closeBrowser() {
        log.info("Close the browser");
    }

}
