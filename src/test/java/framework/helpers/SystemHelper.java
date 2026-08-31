package framework.helpers;

import java.net.URL;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class SystemHelper {
    public static boolean isWindows() {
        return System.getProperty("os.name")
                .toLowerCase()
                .startsWith("windows");
    }

    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    public static String getResourcePath(String fileName) {
        return SystemHelper.class.getClassLoader().getResource(fileName).getPath();
    }
}
