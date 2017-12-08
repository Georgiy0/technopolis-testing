package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class SecretGroupAccess extends TestBase {

    /**
     * Данный тест проверяет недоступность содержания секретной группы
     * для пользователей в неё не входящих.
     * @throws Exception
     */
    @Test
    public void testSecretGroupAccess() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("config/auth.conf"));
        UserMainPage userMainPage = new UserMainPage(driver);

        GroupMainPage groupMainPage = userMainPage.clickGroupsOnToolbar();
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();

        String groupName = "SecretTestGroup";
        groupMainPage.typeGroupName(groupName);
        groupMainPage.clickSecretGroupRadioOpetion();

        GroupPage groupPage = clickCreateButton();
        String newGroupName = groupPage.getGroupName();

        // Проверка имени созданой секретной группы.
        Assert.assertTrue("Не верное имя группы", groupName.equals(newGroupName));

        // Сохранение ID созданой секретной группы.
        String secretGroupID = groupPage.getCurrentURL();

        groupPage.doLogout();
        LoginMainPage loginMainPage = new LoginMainPage(driver);

                // Необходимо использовать нового бота.
        loginMainPage.doLogin(new TestBot("config/auth2.conf"));

        loginMainPage.getPageByURL(secretGroupID);
        GroupNotFoundPage groupNotFoundPage = new GroupNotFoundPage(driver);

        Assert.assertTrue("Не вывилась страница 404.", groupNotFoundPage.check404());
    }
}
