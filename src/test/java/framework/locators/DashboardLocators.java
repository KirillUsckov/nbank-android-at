package framework.locators;

import com.codeborne.selenide.Selectors;

import org.openqa.selenium.By;

public final class DashboardLocators {
    public static final By TITLE = Selectors.byXpath("//android.widget.TextView[@text='Dashboard']");
    public static final By DEPOSIT_MONEY_BUTTON = Selectors.byXpath("//android.view.ViewGroup[contains(@content-desc(),'Deposit Money')]");
    public static final By TRANSFER_MONEY_BUTTON = Selectors.byXpath("//android.view.ViewGroup[contains(@content-desc(),'Make a Transfer')]");
    public static final By CREATE_NEW_ACCOUNT_BUTTON = Selectors.byXpath("//android.view.ViewGroup[contains(@content-desc(),'Create New Account')]");
    public static final By LOGOUT_BUTTON = Selectors.byXpath("//android.view.ViewGroup[contains(@content-desc(),'Logout')]");

}
