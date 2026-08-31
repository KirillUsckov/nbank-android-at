package framework.screens;

import org.openqa.selenium.By;

import framework.locators.AdminPanelLocators;

public class AdminPanelScreen extends BaseScreen{
    private AdminPanelScreen() {
        super(AdminPanelLocators.TITLE);
    }

    public static AdminPanelScreen get() {
        return (AdminPanelScreen) getInstance(instance, AdminPanelScreen::new);
    }
}
