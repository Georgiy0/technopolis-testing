package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

/**
 * Это обёртка для популярных групп на главной странице групп.
 */
public class GroupWrapper {
    private WebDriver driver;
    private final WebElement element;

    private static final By NAME = By.xpath(".//*[contains(@class,'group-name-link')]");
    private static final By SUBSCRIBERS_CNT = By.xpath("//*[contains(@class, 'lp-t') and (contains(text(), 'участников') or contains(text(), 'участник'))]");

    /**
     * @param driver  Драйвер браузера.
     * @param element Элемент, который соответствует популярной группе.
     */
    public GroupWrapper(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    public void scroll() {
        Actions actions = new Actions(driver);
        actions.sendKeys(element, Keys.PAGE_DOWN).build().perform();
    }

    /**
     * @return Имя популярной группы.
     */
    public String getName() {
        return element.findElement(NAME).getText();
    }

    /**
     * @return Текст с количеством подписчиков популярной группы.
     */
    public String getSubscribersCnt() {
        return element.findElement(SUBSCRIBERS_CNT).getText();
    }
}
