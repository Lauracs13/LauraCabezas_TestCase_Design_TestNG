package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;

public class LoginTest extends BaseTest {
    @Test
    public void doingLogin() {
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogInOption();
        homepage.switchToLoginIframe();
        checkThat("Login modal presented", homepage.isLoginModalPresent(), is(true));
        checkThat("ESPN logo presented", homepage.isESPNLogoPresent(), is(true));
        checkThat("Log In button presented", homepage.isLogInButtonPresent(), is(true));
        checkThat("Sign Up button presented", homepage.isSignUpButtonPresent(), is(true));
    }
}
