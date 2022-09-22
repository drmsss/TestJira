package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.ProjectPageElem.*;

public class ProjectPageSteps {
    @Step("Открываем все задачи проекта")
    public static void openAllTasks() {
        allTasksButton.click();
    }

    @Step("Получаем количество задач в проекте")
    public static String getTasksCount() {
        String tasksCount = tasksCountLabel.text();
        return tasksCount;
    }
    @Step("Ищем задачу с именем {summary}")
    public static void searchTask(String taskSummary) {
        searchField.setValue(taskSummary);
        searchButton.click();
    }

    @Step("Получаем статус задачи")
    public static String getTaskStatus() {
        return statusLabel.text();
    }

    @Step("Получаем затронутую версию в задаче")
    public static String getTaskAffectedVersion() {
        return affectedVersionsValue.text();
    }

    @Step("Нажимаем кнопку Создать")
    public static void clickCreateButton() {
        createTaskButton.shouldBe(Condition.enabled).click();
    }

    @Step("Открываем только что созданную задачу")
    public static void goToCreatedTask() {
        taskCreationLabel.shouldBe(Condition.visible).click();
    }
}
