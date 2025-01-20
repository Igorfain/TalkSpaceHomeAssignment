package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionBot {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ActionBot(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * Wait for an element to be visible.
     */
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for an element to be present in the DOM.
     */
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Click on an element after ensuring it's visible.
     */
    public void click(By locator) {
        waitForVisibility(locator).click();
    }

    /**
     * Enter text into an element after ensuring it's visible.
     */
    public void enterText(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get text from an element.
     */
    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    /**
     * Find a WebElement using the given locator.
     *
     * @param locator the By locator for the element
     * @return the found WebElement
     */
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}
