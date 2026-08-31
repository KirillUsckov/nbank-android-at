package framework.screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import framework.locators.ToastLocators;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Toast extends BaseScreen {
    private Toast() {
        super(ToastLocators.TOAST);
    }

    public static Toast get() {
        return (Toast) getInstance(instance, Toast::new);
    }

    @Step("Get toast title")
    public String getTitle() {
        return $(screenLocator).$(ToastLocators.TITLE)
                .shouldBe(Condition.visible)
                .getText();
    }

    @Step("Get toast description")
    public String getDescription() {
        return $(screenLocator).$(ToastLocators.DESCRIPTION)
                .shouldBe(Condition.visible)
                .getText();
    }
}
