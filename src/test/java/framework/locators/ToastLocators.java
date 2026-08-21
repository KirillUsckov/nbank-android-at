package framework.locators;

import com.codeborne.selenide.Selectors;

import org.openqa.selenium.By;

public final class ToastLocators {
    public static final By TOAST =
            By.id("toastAnimatedContainer");
    public static final By TITLE =
//            Selectors.by("resource-id", "toastText1");
            By.id("toastText1");
    public static final By DESCRIPTION =
//            Selectors.by("resource-id", "toastText2");
            By.id("toastText2");
}
