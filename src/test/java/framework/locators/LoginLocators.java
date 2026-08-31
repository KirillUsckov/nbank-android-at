package framework.locators;

import com.codeborne.selenide.Selectors;

import org.openqa.selenium.By;

public final class LoginLocators {
    public final static By USERNAME_INPUT = Selectors.byXpath("//android.widget.EditText[@text='Username']");
    public final static By PASSWORD_INPUT = Selectors.byXpath("//android.widget.EditText[@text='Password']");
    public final static By LOGIN_BUTTON = Selectors.byAttribute("content-desc", "Login");
}
