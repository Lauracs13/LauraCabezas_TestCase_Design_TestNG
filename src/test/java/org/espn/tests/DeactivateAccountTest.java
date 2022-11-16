package org.espn.tests;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;

public class DeactivateAccountTest extends BaseTest{
    @Test
    public void deactivateAccount() throws InterruptedException {
        homepage.closePromoBannerIfExists();
        this.logIn();
        homepage.hoverTheMouseOnUserIcon();
        homepage.clickOnEspnProfile();
        homepage.switchToLoginIframe();
        homepage.clickOnDeleteAccountLink();
        homepage.waitForSeconds(1);
        homepage.clickOnConfirmDeleteAccount();
        homepage.waitForSeconds(1);
        //checkThat("Successfully deactivated account", homepage.isDeactivateAccountMessagePresent(), is(true));
       homepage.waitForDeleteConfirmation();
       homepage.clickOnSubmitButton();
         homepage.exitTheIFrame();
        homepage.hoverTheMouseOnUserIcon();
        homepage.confirmLogOut();
        homepage.waitForSeconds(1);
       this.logIn();
       // homepage.switchToLoginIframe();
        checkThat("Message cannot login with deactivated account is shown", homepage.modalTitleText(), is("Account Deactivated"));
    }
}
