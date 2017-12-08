package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page страницы группы.
 */
public class GroupPage extends PageBase {
    private static final By GROUP_INFO = By.xpath("//*[contains(@class,'group-info-panel')]");
    private static final By GROUP_NAME = By.xpath("//*[contains(@class,'mctc_name_tx')]");

    private static final By USER_CARD = By.xpath("//*[contains(@class, 'ucard-mini toolbar_ucard')]");
    private static final By EXIT_BUTTON = By.xpath("//*[contains(@data-l, 'logoutCurrentUser')]");
    private static final By EXIT_CONFIRM = By.xpath("//*[contains(@data-l, 'confirm')]");


    public GroupPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue(new  WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return isElementPresent(GROUP_INFO);
            }
        }));
    }

    public String getGroupName() {
        return driver.findElement(GROUP_NAME).getText();
    }

    private void clickUserCard() {
        Assert.assertTrue("Иконка пользователя отсутствует на странице.", isElementPresent(USER_CARD));
        click(USER_CARD);
    }

    private void clickExitButton() {
        Assert.assertTrue("Кнопка выхода отсутствует на странице.", isElementPresent(EXIT_BUTTON));
        click(EXIT_BUTTON);
    }

    private void clickExitConfirm() {
        Assert.assertTrue("Кнопка подтверждения выхода отсутствует на странице.", isElementPresent(EXIT_CONFIRM));
        click(EXIT_CONFIRM);
    }

    public void doLogout() {
        clickUserCard();
        clickExitButton();
        clickExitConfirm();
    }
}
