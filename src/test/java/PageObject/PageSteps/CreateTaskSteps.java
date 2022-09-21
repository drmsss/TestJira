package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.CreateTaskPage.*;

public class CreateTaskSteps {

    @Step("Создаем задачу")
    public static void createTask(String taskType, String summary, String description) {
        taskTypeSelector.click();
        typeTask.sendKeys(taskType);
        summaryField.setValue(summary);
        textButton.click();
        descriptionField.sendKeys(description);
        createButton.click();
    }


}
