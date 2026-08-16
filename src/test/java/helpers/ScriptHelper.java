package helpers;

import static io.qameta.allure.Allure.step;

import java.io.File;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ScriptHelper {

    public static final String START_EMULATOR = "scripts/start-emulator.sh";
    public static final String STOP_EMULATOR = "scripts/stop-emulator.sh";

    public static void execute(String scriptName) {
        step("Run script with name " + scriptName, () -> {
            var projectDir = System.getProperty("user.dir");

            boolean isWindows = System.getProperty("os.name")
                    .toLowerCase()
                    .startsWith("windows");

            String bash = isWindows
                    ? "C:\\Program Files\\Git\\bin\\bash.exe"
                    : "bash";

            ProcessBuilder processBuilder = new ProcessBuilder(
                    bash,
                    scriptName
            );

            processBuilder.directory(new File(projectDir));

            // Показываем stdout/stderr скрипта в консоли тестов
            processBuilder.inheritIO();

            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            if (exitCode != 0) {
                throw new RuntimeException(
                        "Failed to execute script: "
                                + scriptName
                                + ". Exit code: "
                                + exitCode
                );
            }

            System.out.println(
                    "Script '" + scriptName + "' executed successfully"
            );
        });
    }
}