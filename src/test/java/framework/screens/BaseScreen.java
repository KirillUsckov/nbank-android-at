package framework.screens;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseScreen {
    protected static BaseScreen instance;
    protected final By screenLocator;

    @Step("Wait for screen opening")
    public BaseScreen waitForOpening() {
        $(screenLocator).shouldBe(Condition.visible);
        return this;
    }

    @Step("Wait for screen closing")
    public BaseScreen waitForClose() {
        $(screenLocator).shouldBe(Condition.not(Condition.exist));
        return this;
    }

    @Step("Check is screen opened")
    public boolean isOpened() {
        return $(screenLocator).isDisplayed();
    }

    protected static <T extends BaseScreen> T getInstance(
            T instance,
            Supplier<T> supplier
    ) {
        return instance != null ? instance : supplier.get();
    }
}
