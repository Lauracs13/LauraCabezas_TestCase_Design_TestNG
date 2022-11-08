package com.globant.web.tests;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class LogOutTest {
    Logger log = Logger.getLogger(String.valueOf(LogOutTest.class));

    @BeforeMethod
    public void verifyUserLoggedIn() {
        log.info("Verify that the user is logged in");
    }

    @Test
    public void LogOut() {
        log.info("Click on the icon upper right");
        log.info("Click on the Log Out option");
    }

    @AfterMethod
    public void closeBrowser() {
        log.info("Close the browser");
    }
}
