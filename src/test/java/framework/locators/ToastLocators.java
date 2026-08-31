package framework.locators;

import com.codeborne.selenide.Selectors;

import org.openqa.selenium.By;

public final class ToastLocators {
    public static final By TOAST =
            By.id("toastAnimatedContainer");
    public static final By TITLE =
            By.id("toastText1");
    public static final By DESCRIPTION =
            By.id("toastText2");
}
