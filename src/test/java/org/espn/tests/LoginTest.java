package org.espn.tests;

import org.espn.pages.HomePage;
import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;

public class LoginTest extends BaseTest {


    @Test
    public void doingLogin() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        checkThat("Login modal is shown", homepage.isLoginModalPresent(), is(true));
        checkThat("ESPN logo is shown", homepage.isESPNLogoPresent(), is(true));
        checkThat("Log In button is shown", homepage.isLogInButtonPresent(), is(true));
        checkThat("Sign Up button is shown", homepage.isSignUpButtonPresent(), is(true));
        homepage.closeModalLogin();
        homepage.exitTheIFrame();
        this.logIn();
        WatchPage watchPage = homepage.switchToWatchPage();
        checkThat("All cards from first carousel have title", watchPage.haveAllCardsTitle(), is(true));
        checkThat("All cards from first carousel have description", watchPage.haveAllCardsDescription(), is(true));
        watchPage.clickOnSecondCard();
        checkThat("Close button is shown", watchPage.isCloseModalButton(), is(true));
        watchPage.clickOnCloseModalButton();
        HomePage homePage = watchPage.goBackToHomePage();
        homepage.hoverTheMouseOnUserIcon();
        checkThat("User name is correct", homePage.navText(), is("Welcome pepita!"));
        homepage.closePromoBannerIfExists();
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogOutOption();
        homepage.hoverTheMouseOnUserIcon();
        checkThat("User name has removed successfully", homePage.navText(), is("Welcome!"));
    }
}
