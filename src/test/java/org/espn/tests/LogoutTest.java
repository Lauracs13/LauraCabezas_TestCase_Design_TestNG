package org.espn.tests;

import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.is;

public class LogoutTest extends BaseTest{
    @Test
    public void doingLogout() {
        homepage.closePromoBannerIfExists();
        this.logIn();
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnLogOutOption();
        homepage.hoverTheMouseOnUserIcon();
        checkThat("User name has removed successfully", homepage.navText(), is("Welcome!"));
    }
}
