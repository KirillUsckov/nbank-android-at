package framework.screens;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;

import framework.locators.LoginLocators;
import io.qameta.allure.Step;

public class LoginScreen extends BaseScreen {
    private LoginScreen() {
        super(LoginLocators.LOGIN_BUTTON);
    }

    public static LoginScreen get() {
        return (LoginScreen) getInstance(instance, LoginScreen::new);
    }

    @Step("Enter username on login page")
    public LoginScreen enterUsername(String username) {
        $(LoginLocators.USERNAME_INPUT).shouldBe(Condition.visible).sendKeys(username);
        return this;
    }

    @Step("Enter password on login page")
    public LoginScreen enterPassword(String password) {
        $(LoginLocators.PASSWORD_INPUT).shouldBe(Condition.visible).sendKeys(password);
        return this;
    }

    @Step("Click login button on login page")
    public LoginScreen clickLoginButton() {
        $(LoginLocators.LOGIN_BUTTON).shouldBe(Condition.visible).shouldBe(Condition.clickable).click();
        return this;
    }
}
