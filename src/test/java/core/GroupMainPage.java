package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GroupMainPage extends PageBase {

    private static final By CREATE_NEW_GROUP = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");
    private static final By INTEREST_GROUP = By.xpath("//*[contains(@class,'create-group-dialog_img') and contains(@class, '__interest')]");
    private static final By GROUPS = By.xpath("//*[contains(@data-l,'groupCard,POPULAR_GROUPS')]");
    private static final By CREATE_GROUP_INPUT_SECRET = By.xpath("//*[contains(@value,'BY_MEMBER_INVITATION') and not(contains(@value,'BY_MEMBER_INVITATION_AND_REQUEST')) ]");

    public GroupMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue(new  WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return isElementPresent(CREATE_NEW_GROUP);
            }
        }));
    }

    public void typeGroupName(String groupName) {
        type(groupName, By.id("field_name"));
    }

    public void clickInterestGroup() { click(INTEREST_GROUP); }

    public void clickCreateGroup() {
        Assert.assertTrue("Не найден элемент создания группы", isElementPresent(CREATE_NEW_GROUP));
        click(CREATE_NEW_GROUP);
    }

    public void clickSecretGroupRadioOpetion() {
        Assert.assertTrue("Не найден элемент создания группы", isElementPresent(CREATE_GROUP_INPUT_SECRET));
        click(CREATE_GROUP_INPUT_SECRET);
    }

    /**
     * Метод загружает по локатору список всех популярных групп со страницы,
     * оборачивая их в GroupWrapper.
     *
     * @return Список всех популярных группы в виде GroupWrapper.
     */
    public List<GroupWrapper> getGroups() {
        List<WebElement> groupsElements = driver.findElements(GROUPS);
        List<GroupWrapper> groups = new ArrayList<>(groupsElements.size());
        for (WebElement groupElement : groupsElements) {
            groups.add(new GroupWrapper(driver, groupElement));
        }
        return groups;
    }

    /**
     * Метод переходит к указанной группе, опускаясь по странице вниз.
     *
     * @param wrapper группа, к которой необходимо перейти.
     */
    public void scrollToNewGroups(GroupWrapper wrapper) {
        wrapper.scroll();
    }

}
