import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import framework.constants.Scripts;
import framework.extensions.EmulatorDriverSetUpExtension;
import framework.extensions.EmulatorDriverTearDownExtension;
import framework.helpers.ApiHelper;
import framework.helpers.ScriptHelper;

@ExtendWith({EmulatorDriverSetUpExtension.class, EmulatorDriverTearDownExtension.class})
public abstract class BaseTest {
    @BeforeAll
    public static void setUp() {
        ApiHelper.healthCheck();
        ScriptHelper.execute(Scripts.START_EMULATOR);
    }

    public void stopDriver() {
        Selenide.closeWebDriver();
    }

    @AfterAll
    public static void tearDown() {
        ScriptHelper.execute(Scripts.STOP_EMULATOR);
    }
}
