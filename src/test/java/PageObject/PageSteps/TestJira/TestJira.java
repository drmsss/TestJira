package PageObject.PageSteps.TestJira;

import Hooks.WebHooks;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static PageObject.PageElements.ProjectPageElem.*;
import static PageObject.PageElements.TaskScreenElem.*;
import static PageObject.PageSteps.AuthorizationPageSteps.*;
import static PageObject.PageSteps.CreateTaskSteps.*;
import static PageObject.PageSteps.MainPageSteps.*;
import static PageObject.PageSteps.ProjectPageSteps.*;
import static PageObject.PageSteps.TaskScreenSteps.*;
import static utils.Configuration.*;

public class TestJira extends WebHooks {

    @Test
    @DisplayName("Авторизация на сайте")
    public void Test_1() {
        openUrl(getConfigurationValue("jiraUrl"));
        login(getConfigurationValue("login"));
    }

    @Test
    @DisplayName("Открыть проект TEST и проверить количество задач в нем")
    public void Test_2() {
        openUrl(getConfigurationValue("jiraUrl"));
        login(getConfigurationValue("login"));
        openTestProject();
        Assertions.assertEquals("Test", projectNameValue.text());
        System.out.println("Количество задач в проекте: " + getTasksCount().substring(getTasksCount().lastIndexOf(" ")+1));
    }

    @Test
    @DisplayName("Проверить в задаче статус и привязку к версии")
    public void Test_3() {
        openUrl(getConfigurationValue("jiraUrl"));
        login(getConfigurationValue("login"));
        openTestProject();
        Assertions.assertEquals("Test", projectNameValue.text());
        openAllTasks();
        searchTask("TestSelenium_bug");
        System.out.println("Статус задачи: " + getTaskStatus());
        Assertions.assertEquals("СДЕЛАТЬ", getTaskStatus());
        System.out.println("Затронута версия: " + getTaskAffectedVersion());
        Assertions.assertEquals("Version 2.0", getTaskAffectedVersion());
    }

    @Test
    @DisplayName("Создать новую задачу и перевести по статусам до закрытого")
    public void Test_4() {
        openUrl(getConfigurationValue("jiraUrl"));
        login(getConfigurationValue("login"));
        openTestProject();
        //Assertions.assertEquals("Test", projectNameValue.text());
        openAllTasks();
        clickCreateButton();
        createTask("Ошибка","Test bug", "Test bug description");
        goToCreatedTask();
        Assertions.assertEquals("Test", projectNameValue.text());
        Assertions.assertEquals("Test bug", taskSummary.text());
        Assertions.assertEquals("Test bug description", taskDescription.text());
        setStatusInProgress();
        setStatusDone();
    }

}
