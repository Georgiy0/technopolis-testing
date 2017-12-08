package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Это группа тестов, которая проверяет главную страницу групп пользователя.
 */
public class MainGroupPageTest extends TestBase {

    private GroupMainPage groupMainPage;

    /**
     * Метод аутентифицирует пользователя, переходит к главной странице пользователя и загружает главную страницу групп.
     */
    @Before
    public void gotoGroupMainPage() throws IOException {
        new LoginMainPage(driver).doLogin(new TestBot("config/auth.conf"));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickGroupsOnToolbar();
        groupMainPage = new GroupMainPage(driver);
    }

    /**
     * Тест проверяет список популярных групп на главной странице.
     * Происходит проверка, что количество популярных групп ненулевое.
     * Для найденных популярных групп производится проверка на
     * наличие имени группы и количества подписчиков.
     */
    @Test
    public void testGroupsList() {
        List<GroupWrapper> groups = groupMainPage.getGroups();
        Assert.assertTrue("Популярные группы не отображаются.", groups.size() > 0);
        for (GroupWrapper group : groups) {
            Assert.assertTrue("Группа не содержит имени.", !group.getName().isEmpty());
            Assert.assertTrue("Группа не содержит счётчика подписчиков.", !group.getSubscribersCnt().isEmpty());
        }
    }

    /**
     * Тест проверяет список популярных групп на главной странице.
     * Происходит проверка, что количество популярных групп ненулевое.
     */

    /**
     * Тест проверяет список популярных групп на главной странице.
     * Сохраняется текущее количество групп.
     * Затем происходит переход к последнему элементу вниз,
     * что должно приводить к загрузки новых популярных групп.
     * Проверяется, что количество групп увеличилось.
     *
     * @throws InterruptedException
     */
    @Test
    public void testGroupsAmountIncrease() throws InterruptedException {
        List<GroupWrapper> groups = groupMainPage.getGroups();
        int old_size = groups.size();
        groupMainPage.scrollToNewGroups(groups.get(groups.size() - 1));
        Thread.sleep(1000);
        groups = groupMainPage.getGroups();
        Assert.assertTrue("Новые популярные группы не подгрузились.", groups.size() > old_size);
    }
}
