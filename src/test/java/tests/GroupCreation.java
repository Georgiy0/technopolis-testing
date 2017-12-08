package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class GroupCreation extends TestBase {

    /**
     * Тест проверяет функционал создания новой группы.
     * @throws Exception
     */
    @Test
    public void testGroupCreation() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("config/auth.conf"));
        UserMainPage userMainPage = new UserMainPage(driver);

        GroupMainPage groupMainPage = userMainPage.clickGroupsOnToolbar();
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();

        String groupName = "TestGroup";
        groupMainPage.typeGroupName(groupName);

        GroupPage groupPage = clickCreateButton();
        String newGroupName = groupPage.getGroupName();

        Assert.assertTrue("Не верное имя группы.", groupName.equals(newGroupName));
    }
}