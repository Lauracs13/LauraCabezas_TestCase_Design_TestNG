package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class DeactivateAccountTest extends BaseTest {
    @Test
    public void deactivateAccount() {
        homepage.closePromoBannerIfExists();
        this.logIn();
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnEspnProfile();
        homepage.switchToLoginIframe();
        homepage.clickOnDeleteAccountLink();
        homepage.clickOnConfirmDeleteAccount();
        homepage.clickOnConfirm();
        homepage.exitTheIFrame();
        homepage.waitForDeactivateAccountSuccess();
        this.logIn();
        checkThat("Message cannot login with deactivated account is shown", homepage.modalTitleText(), is("Account Deactivated"));
    }
}
