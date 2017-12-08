package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMainPage extends PageBase {

    private static final By GROUPS_ON_TOOLBAR = By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue(new  WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return isElementPresent(GROUPS_ON_TOOLBAR);
            }
        }));
    }

    public GroupMainPage clickGroupsOnToolbar() {
        Assert.assertTrue("Отсутствует вкладка групп.", isElementPresent(GROUPS_ON_TOOLBAR));
        click(GROUPS_ON_TOOLBAR);
        return new GroupMainPage(driver);
    }
}
