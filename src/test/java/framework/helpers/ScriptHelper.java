package framework.helpers;

import static io.qameta.allure.Allure.step;

import java.io.File;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ScriptHelper {
    public static void execute(String scriptName) {
        step("Run script with name " + scriptName, () -> {
            String bash = SystemHelper.isWindows()
                    ? "C:\\Program Files\\Git\\bin\\bash.exe" // for local tests
                    : "bash";

            ProcessBuilder processBuilder = new ProcessBuilder(
                    bash,
                    scriptName
            );

            processBuilder.directory(new File(SystemHelper.getUserDir()));

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