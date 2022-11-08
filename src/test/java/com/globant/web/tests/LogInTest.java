package com.globant.web.tests;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class LogInTest {

    Logger log = Logger.getLogger(String.valueOf(LogInTest.class));

    @BeforeSuite
    public void verifyAccount() {
        log.info("Verify that a valid ESPN account is used");
    }

    @BeforeClass
    public void openWebBrowser() {
        log.info("Open the web browser");
    }

    @BeforeMethod
    public void searchTheUrl() {
        log.info("Enter the URL https://www.espnqa.com/?_adbock=true&src=com in the browsers search box ");
    }

    @Parameters({"email", "password"})
    @Test
    public void LogIn(String email, String password) {
        log.info("Click on the icon upper right");
        log.info("Click on the Log In option");
        log.info("Type the username " + email + " on the username or email address box");
        log.info("Type the password " + password + " on the password box");
        log.info("Click on Log In option");
    }

    @AfterClass
    public void closeBrowser() {
        log.info("Close the browser");
    }
}