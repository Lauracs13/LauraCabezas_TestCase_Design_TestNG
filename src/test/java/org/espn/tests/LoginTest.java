package org.espn.tests;

import com.google.j2objc.annotations.Weak;
import org.espn.configuration.Driver;
import org.espn.pages.HomePage;
import org.espn.pages.WatchPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.espn.pages.BasePage;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class LoginTest extends BaseTest {

    @Parameters({"username1", "password1"})
    @Test
    public void doingLogin(String username1, String password1) {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        checkThat("Login modal presented", homepage.isLoginModalPresent(), is(true));
        checkThat("ESPN logo presented", homepage.isESPNLogoPresent(), is(true));
        checkThat("Log In button presented", homepage.isLogInButtonPresent(), is(true));
        checkThat("Sign Up button presented", homepage.isSignUpButtonPresent(), is(true));
        homepage.closeModalLogin();
        homepage.exitTheLoginIFrame();
        this.logIn(username1, password1);
        WatchPage watchPage = homepage.switchToWatchPage();
        checkThat("All cards from first carousel have title", watchPage.haveAllCardsTitle(), is(true));
        checkThat("All cards from first carousel have description", watchPage.haveAllCardsDescription(), is(true));
        watchPage.clickOnSecondCard();
    }
}
