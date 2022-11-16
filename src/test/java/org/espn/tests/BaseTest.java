package org.espn.tests;

import org.espn.configuration.Driver;
import org.espn.pages.HomePage;


import org.espn.reporting.Reporter;
import org.testng.annotations.*;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;


public class BaseTest {
    private Driver driver;
    protected HomePage homepage;
    private static final String FIRSTNAME = "pepito";
    private static final String LASTNAME = "perez";
    private final String PASSWORD = "pepitoPerez1";
    private static String email = FIRSTNAME + "." + LASTNAME + (int)Math.floor(Math.random() * 1000) + "@email.com";

    @Parameters({"browser", "url"})
    @BeforeSuite
    public void signUp(String browser, String url) {
        this.testSetUp(browser, url);
/*        homepage.switchToPromoBannerIframe();
        homepage.closePromoBanner();
        homepage.exitTheIFrame();*/
        homepage.closePromoBannerIfExists();
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        homepage.clickOnSignUpButton();
        homepage.typeTheFirstName(FIRSTNAME);
        homepage.typeTheLastName(LASTNAME);
        homepage.typeTheEmail(email);
        homepage.typeTheNewPassword(PASSWORD);
        //homepage.scrollToBottom();
        homepage.clickOnLoginButton();
        homepage.waitForLoginSuccess();
        this.tearDown();
    }

    @Parameters({"browser", "url"})
    @BeforeClass
    public void testSetUp(String browser, String url) {
        driver = new Driver(browser);
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homepage = new HomePage(driver.getDriver());

    }

    @AfterClass
    public void tearDown() {
        driver.getDriver().quit();
    }

    protected <T> void checkThat(
            String description, T actualValue, Matcher<? super T> expectedValue) {
        Reporter.info(
                format("Checking that " + description.toLowerCase() + "[Expectation: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e) {
            Reporter.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }

    protected void logIn() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        homepage.clickOnUsername();
        homepage.typeTheUsername(email);
        homepage.clickOnPassword();
        homepage.typeThePassword(this.PASSWORD);
        homepage.clickOnLoginButton();

    }

}
