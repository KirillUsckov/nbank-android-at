package framework.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import framework.confs.Config;
import framework.enums.ConfigParams;
import framework.helpers.SystemHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class EmulatorDriverSetUpExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        try {
            Configuration.timeout =
                    Config.getLongProperty(ConfigParams.SELENIDE_TIMEOUT);
            String appPath = new File(Config.getProperty(ConfigParams.APP_PATH))
                    .getAbsolutePath();
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(Config.getProperty(ConfigParams.PLATFORM_NAME))
                    .setDeviceName(Config.getProperty(ConfigParams.DEVICE_NAME))
                    .setAppPackage(Config.getProperty(ConfigParams.APP_PACKAGE))
                    .setAppActivity(Config.getProperty(ConfigParams.APP_ACTIVITY))
                    .setNoReset(false)
                    .setFullReset(false)
                    .setSkipDeviceInitialization(true)
                    .setApp(appPath);
            options.setCapability("disableIdLocatorAutocompletion", true);

            AndroidDriver driver = new AndroidDriver(
                    new URI(Config.getProperty(ConfigParams.APPIUM_URL)).toURL(),
                    options
            );
            WebDriverRunner.setWebDriver(driver);
            Selenide.open();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
