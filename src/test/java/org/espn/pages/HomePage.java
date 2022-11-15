package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;
    @FindBy(css = "#global-header .tools .global-user-container>ul:first-child>li:last-child>a")
    private WebElement loginElement;

  // @FindBy(css = ".loading-container .view-starry-night")
//@FindBy (xpath = "//*[@id=\"root\"]/div[3]/div/div/div[1]")
  @FindBy(css = ".view-starry-night >div:first-child")
    private WebElement loginModal;
@FindBy (id = "oneid-iframe")
private WebElement loginIframe;
@FindBy(id = "logo")
    private WebElement espnLogo;
    @FindBy(css = ".input-InputLoginValue")
    private WebElement usernameInput;
    @FindBy(css = ".input-InputPassword")
    private WebElement loginPassword;
    @FindBy(id = "BtnSubmit")
    private WebElement loginButton;
    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    @FindBy(css = "#global-header .tools .global-user-container>ul:first-child:not(.alt-format)>li.display-user>span")
    private WebElement welcomeUserMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverTheMouseOnUserIcon() {
        super.hoverTheMouseOnElement(this.userIcon);
    }
    public void clickOnLogInOption() {
        super.clickElement(this.loginElement);
    }
    public void switchToLoginIframe() {
        super.getDriver().switchTo().frame(this.loginIframe);
    }
    public boolean isLoginModalPresent() {
        super.waitForVisibility(this.loginModal);
        return this.loginModal.isDisplayed();
    }
    public boolean isESPNLogoPresent(){
        super.waitForVisibility(this.espnLogo);
        return this.espnLogo.isDisplayed();
    }
    public boolean isLogInButtonPresent(){
        super.waitForVisibility(this.loginButton);
        return this.loginButton.isDisplayed();
    }

    public boolean isSignUpButtonPresent(){
        super.waitForVisibility(this.signUpButton);
        return this.signUpButton.isDisplayed();
    }
    public void typeTheUsername(String text) {
        super.typeOnInput(this.usernameInput, text);
    }

    public void typeThePassword(String text) {
        super.typeOnInput(this.loginPassword, text);
    }
    public String navText(){
        super.waitForVisibility(this.welcomeUserMessage);
        return this.welcomeUserMessage.getText();
    }
}
