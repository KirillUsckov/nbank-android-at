import net.bytebuddy.utility.RandomString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import framework.assertions.ToastAssertions;
import framework.enums.ErrorToasts;
import framework.enums.SuccessfulToasts;
import framework.models.User;
import framework.screens.AdminPanelScreen;
import framework.screens.LoginScreen;
import framework.screens.Toast;

public class LoginTests extends BaseTest {
    private final LoginScreen loginScreen = LoginScreen.get();
    private final Toast toast = Toast.get();
    private final AdminPanelScreen adminPanelScreen = AdminPanelScreen.get();
    private final User admin = User.builder().username("admin").password("admin").build();

    @Test
    @DisplayName("Admin sees admin panel page after successful login")
    public void shouldOpenAdminPanelForSuccessAdminLogin() {
        loginScreen.enterUsername(admin.getUsername())
                .enterPassword(admin.getPassword())
                .clickLoginButton();

        String toastTitle = toast.getTitle();
        String toastText = toast.getDescription();
        ToastAssertions.assertSuccessToast(SuccessfulToasts.LOGIN, toastTitle, toastText);
        toast.waitForClose();

        adminPanelScreen.waitForOpening();
        Assertions.assertTrue(adminPanelScreen.isOpened(), "Admin panel screen wasn't opened");
    }

    @Test
    @DisplayName("User sees login error with invalid password")
    public void shouldLoginSuccessfullyWithValidCredentials() {
        loginScreen.enterUsername(admin.getUsername())
                .enterPassword(RandomString.make())
                .clickLoginButton();

        String toastTitle = toast.getTitle();
        String toastText = toast.getDescription();
        ToastAssertions.assertErrorToast(ErrorToasts.LOGIN_401, toastTitle, toastText);
        toast.waitForClose();

        Assertions.assertTrue(loginScreen.isOpened(), "Login screen is not opened");
    }
}
