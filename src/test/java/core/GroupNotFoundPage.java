package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupNotFoundPage extends PageBase {
    private static final By GROUP_NOT_FOUND = By.xpath("//*[contains(@class, 'p404')]");

    public GroupNotFoundPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue(new  WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return isElementPresent(GROUP_NOT_FOUND);
            }
        }));
    }

    public boolean check404() {
        return isElementPresent(GROUP_NOT_FOUND);
    }
}
