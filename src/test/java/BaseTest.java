import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import constants.Scripts;
import helpers.ApiHelper;
import helpers.ScriptHelper;

public abstract class BaseTest {
    @BeforeAll
    public static void setUp() {
        ApiHelper.healthCheck();
        ScriptHelper.execute(Scripts.START_EMULATOR);
    }

    @AfterAll
    public static void tearDown() {
        ScriptHelper.execute(Scripts.STOP_EMULATOR);
    }
}
