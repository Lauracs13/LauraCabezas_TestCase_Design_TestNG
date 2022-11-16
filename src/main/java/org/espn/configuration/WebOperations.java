package org.espn.configuration;

import static org.openqa.selenium.support.PageFactory.initElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void clickElement(WebElement element) {
        waitForVisibility(element);
        waitForClickable(element);
        element.click();
    }

    public void hoverTheMouseOnElement(WebElement element) {
        this.waitForVisibility(element);
        Actions action = new Actions(this.getDriver());
        action.moveToElement(element).perform();
    }

    public void typeOnInput(WebElement element, String text) {
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void scrollToBottom(){
        new Actions(getDriver()).sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void waitForAttributeValue(WebElement element, String attribute, String value) {
        this.wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

}
