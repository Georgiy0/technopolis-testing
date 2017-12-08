package core;

import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;

public class LoginMainPage extends PageBase {



    private static final By USESRNAME_FIELD = By.id("field_email");
    private static final By PASSWORD_FIELD = By.id("field_password");
    private static final By LOGIN_BUTTON = By.cssSelector("div.form-actions > div > .button-pro");

    public LoginMainPage(WebDriver driver) {
        super(driver);
        String baseUrl = "https://ok.ru/";
        driver.get(baseUrl);
    }

    @Override
    protected void check() {
        Assert.assertTrue(new  WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return isElementPresent(LOGIN_BUTTON);
            }
        }));
    }

    public void doLogin(TestBot testBot) {
        type(testBot.getLogin(), USESRNAME_FIELD);
        type(testBot.getPassword(), PASSWORD_FIELD);
        click(LOGIN_BUTTON);
    }


}
