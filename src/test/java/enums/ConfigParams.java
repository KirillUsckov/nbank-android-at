package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ConfigParams {
    BACKEND_URL("backend.url"),
    ADMIN_TOKEN("admin.token"),
    PLATFORM_NAME("platform.name"),
    DEVICE_NAME("device.name"),
    VERSION("version"),
    APP_PACKAGE("app.package"),
    APP_ACTIVITY("app.activity"),
    APPIUM_URL("appium.url");
    @Getter
    private String value;
}