package testdata;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AssertionMessages {
    ADMIN_PANEL_SCREEN_WAS_NOT_OPENED("Admin panel screen wasn't opened"),
    LOGIN_SCREEN_WAS_NOT_OPENED("Login screen was not opened"),
    DASHBOARD_SCREEN_WAS_NOT_OPENED("Dashboard screen wasn't opened");
    private final String message;
}
