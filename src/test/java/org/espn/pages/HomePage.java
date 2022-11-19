package org.espn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.Thread;

public class HomePage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css = "#global-header .tools .global-user-container>ul:first-child>li:last-child>a")
    private WebElement loginElement;
    @FindBy(css = ".view-starry-night >div:first-child")
    private WebElement loginModal;
    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;
    @FindBy(id = "logo")
    private WebElement espnLogo;
    @FindBy(css = ".input-InputLoginValue")
    private WebElement usernameInput;
    @FindBy(css = ".input-InputPassword")
    private WebElement loginPassword;
    @FindBy(css = "button#BtnSubmit")
    private WebElement btnSubmit;
    @FindBy(css = "form.delete-profile-success button#BtnSubmit")
    private WebElement btnSubmit2;
    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(id = "InputFirstName")
    private WebElement inputFirstName;
    @FindBy(id = "InputLastName")
    private WebElement inputLastName;
    @FindBy(id = "InputEmail")
    private WebElement inputEmail;
    @FindBy(id = "password-new")
    private WebElement inputNewPassword;
    @FindBy(css = "#global-header .tools .global-user-container:last-child>ul:first-child>li:nth-child(5)>a")
    private WebElement espnProfileOption;
    @FindBy(id = "close")
    private WebElement closeModalLogin;
    @FindBy(css = "#global-header .tools .global-user-container>ul:first-child:not(.alt-format)>li.display-user>span")
    private WebElement welcomeUserMessage;
    @FindBy(css = "li.watch > a")
    private WebElement watchOption;
    @FindBy(id = "sideLogin-left-rail")
    private WebElement alternativeLogIn;
    @FindBy(css = ".PromoBanner__CloseBtn")
    private WebElement promoBannerCloseBtn;
    @FindBy(css = "a#AccountDeleteLink")
    private WebElement accountDeleteLink;
    @FindBy(css = "h2#Title")
    private WebElement modalTitle;
    @FindBy(id = "sideLogin-left-rail")
    private WebElement divOneIdWrapper;
    @FindBy(css = "p.text-left + button#BtnSubmit")
    private WebElement confirmDeleteAccountBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverTheMouseOnUserIcon() {
        super.waitForVisibility(this.userIcon);
        super.hoverTheMouseOnElement(this.userIcon);
    }

    public void clickOnLogInOption() {
        super.clickElement(this.loginElement);
    }

    public void clickOnLogOutOption() {
        super.clickElement(this.loginElement);
    }

    public void switchToLoginIframe() {
        super.getDriver().switchTo().frame(this.loginIframe);
    }

    public void exitTheIFrame() {
        super.getDriver().switchTo().defaultContent();
    }

    public void closeModalLogin() {
        super.clickElement(this.closeModalLogin);
    }

    public boolean isLoginModalPresent() {
        super.waitForVisibility(this.loginModal);
        return this.loginModal.isDisplayed();
    }

    public boolean isESPNLogoPresent() {
        super.waitForVisibility(this.espnLogo);
        return this.espnLogo.isDisplayed();
    }

    public boolean isLogInButtonPresent() {
        super.waitForVisibility(this.btnSubmit);
        return this.btnSubmit.isDisplayed();
    }

    public boolean isSignUpButtonPresent() {
        super.waitForVisibility(this.signUpButton);
        return this.signUpButton.isDisplayed();
    }

    public void clickOnSignUpButton() {
        super.clickElement(this.signUpButton);
    }

    public void clickOnUsername() {
        super.clickElement(this.usernameInput);
    }

    public void clickOnPassword() {
        super.clickElement(this.loginPassword);
    }

    public void clickOnSubmitButton() {
        super.waitForVisibility(this.btnSubmit);
        super.clickElement(this.btnSubmit);
    }

    public void clickOnConfirm() {
        super.clickElement(this.btnSubmit2);
    }

    public void clickOnEspnProfile() {
        super.clickElement(this.espnProfileOption);
    }

    public void clickOnDeleteAccountLink() {
        super.clickElement(this.accountDeleteLink);
    }

    public void clickOnConfirmDeleteAccount() {
        super.clickElement(this.confirmDeleteAccountBtn);
    }

    public void typeTheUsername(String text) {
        super.typeOnInput(this.usernameInput, text);
    }

    public void typeThePassword(String text) {
        super.typeOnInput(this.loginPassword, text);
    }

    public void typeTheFirstName(String text) {
        super.typeOnInput(this.inputFirstName, text);
    }

    public void typeTheLastName(String text) {
        super.typeOnInput(this.inputLastName, text);
    }

    public void typeTheEmail(String text) {
        super.typeOnInput(this.inputEmail, text);
    }

    public void typeTheNewPassword(String text) {
        super.typeOnInput(this.inputNewPassword, text);
    }

    public String navText() {
        super.waitForVisibility(this.welcomeUserMessage);
        return this.welcomeUserMessage.getText();
    }

    public String modalTitleText() {
        super.waitForVisibility(this.modalTitle);
        return this.modalTitle.getText();
    }

    public WatchPage switchToWatchPage() {
        super.clickElement(this.watchOption);
        return new WatchPage(getDriver());
    }

    public void closePromoBanner() {
        super.clickElement(this.promoBannerCloseBtn);
    }

    public void closePromoBannerIfExists() {

        boolean isPromoBannerShown;
        WebElement promoBanner = null;
        try {
            promoBanner = super.getDriver().findElement(By.cssSelector(".promo-banner-container iframe"));
            isPromoBannerShown = true;
        } catch (NoSuchElementException e) {
            isPromoBannerShown = false;
        }
        if (isPromoBannerShown) {
            super.getDriver().switchTo().frame(promoBanner);
            WebElement closeBtn = super.getDriver().findElement(By.cssSelector(".PromoBanner__CloseBtn"));
            super.clickElement(closeBtn);
            super.getDriver().switchTo().defaultContent();
        }
    }

    public void scrollToBottom() {
        super.scrollToBottom();
    }

    public void waitForLoginSuccess() {
        super.waitForAttributeValue(this.divOneIdWrapper, "style", "display: none;");
    }

    public void waitForDeactivateAccountSuccess() {
        super.waitForAttributeValue(this.alternativeLogIn, "style", "display: block;");
    }

}
