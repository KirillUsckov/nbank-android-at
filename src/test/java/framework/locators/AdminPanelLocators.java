package framework.locators;

import com.codeborne.selenide.Selectors;

import org.openqa.selenium.By;

public final class AdminPanelLocators {
    public static final By TITLE = Selectors.byXpath("//android.widget.TextView[@text='Admin Panel']");
    public static final By CREATE_NEW_USER_LABEL = Selectors.byText("Create New User");
    public final static By USERNAME_INPUT = Selectors.byXpath("//android.widget.EditText[@text='Username']");
    public final static By PASSWORD_INPUT = Selectors.byXpath("//android.widget.EditText[@text='Password']");
    public static final By ADD_USER_BUTTON = Selectors.byAttribute("content-desc", "Add User");
    public static final By LOGOUT_BUTTON = Selectors.byAttribute("content-desc", "Logout");
}
