package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static PageObject.PageElements.AuthorizationPageElem.*;
import static utils.Configuration.getConfigurationValue;


public class AuthorizationPageSteps {

    @Step("Открываем страницу по ссылке {url}")
    public static void openUrl(String url){
        Selenide.open(url);
    }

    @Step("Авторизуемся как пользователь {login}")
    public static void login (String login){
        loginField.shouldBe(Condition.visible).sendKeys(getConfigurationValue("login"));
        passwordField.shouldBe(Condition.visible).sendKeys(getConfigurationValue("password"));
        loginButton.shouldBe(Condition.enabled).click();
    }

}
