package framework.screens;

import org.openqa.selenium.By;

import framework.locators.DashboardLocators;

public class DashboardScreen extends BaseScreen {
    private DashboardScreen() {
        super(DashboardLocators.TITLE);
    }

    public static DashboardScreen get() {
        return (DashboardScreen) getInstance(instance, DashboardScreen::new);
    }
}
