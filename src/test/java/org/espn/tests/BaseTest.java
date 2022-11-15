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
    @AfterTest
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

}
