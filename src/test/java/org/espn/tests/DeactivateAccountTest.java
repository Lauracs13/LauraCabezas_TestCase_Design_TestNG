package org.espn.tests;

import org.testng.annotations.Test;

public class DeactivateAccountTest extends BaseTest{
    @Test
    public void doingLogout() {
        homepage.closePromoBannerIfExists();
        this.logIn();
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnEspnProfile();

    }
}
