package PageObject.PageSteps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static PageObject.PageElements.MainPageElem.*;

public class MainPageSteps {

    @Step("Переходим в проект TEST")
    public static void openTestProject(){
        projectsButton.click();
        testProjectLink.click();
    }
}
