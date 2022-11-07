package com.globant.web.tests;

import org.testng.annotations.*;

import java.util.logging.Logger;

public class LogInTest {

    Logger log = Logger.getLogger(String.valueOf(LogInTest.class));

    @BeforeSuite
    public void initialConditions() {
        log.info("Have an account in ESPN");
    }

    @BeforeClass
    public void openWebBrowser() {
        log.info("Open the web browser");
    }

}