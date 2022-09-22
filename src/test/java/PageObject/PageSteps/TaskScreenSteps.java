package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.TaskScreenElem.*;

public class TaskScreenSteps {
    @Step("Переводим задачу в статус В работе")
    public static void setStatusInProgress() {
        inProgressButton.shouldBe(Condition.enabled).click();
        closePopupButton.shouldBe(Condition.visible).click();
    }
    @Step("Переводим задачу в статус Выполнено")
    public static void setStatusDone() {
        businessProcessButton.shouldBe(Condition.enabled).click();
        doneButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
}

}
