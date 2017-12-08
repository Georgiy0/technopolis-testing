package core;

import org.junit.Assert;
import org.openqa.selenium.*;

public abstract class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

    protected void type(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void getPageByURL(String URL) {
        driver.get(URL);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected boolean isElementVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
