import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import helpers.ApiHelper;
import helpers.ScriptHelper;

public abstract class BaseTest {
    @BeforeAll
    public static void setUp() {
        ApiHelper.healthCheck();
        ScriptHelper.execute(ScriptHelper.START_EMULATOR);
    }

    @AfterAll
    public static void tearDown() {
        ScriptHelper.execute(ScriptHelper.STOP_EMULATOR);
    }
}
