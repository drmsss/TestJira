package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.TaskScreenElem.*;

public class TaskScreenSteps {
    @Step("Переводим задачу в статус В работе")
    public static void setStatusInProgress() {
        inProgressButton.click();
    }
    @Step("Переводим задачу в статус Выполнено")
    public static void setStatusDone() {
        businessProcessButton.click();
        doneButton.click();
    }

}
