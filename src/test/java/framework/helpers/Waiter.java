package framework.helpers;

import com.codeborne.selenide.Selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import framework.confs.Config;
import framework.enums.ConfigParams;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Waiter {
    public static void waitForElementDisplayed(By locator) {
        new WebDriverWait(Selenide.webdriver().driver().getWebDriver(), Duration.ofSeconds(Config.getLongProperty(ConfigParams.SELENIDE_TIMEOUT)))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
