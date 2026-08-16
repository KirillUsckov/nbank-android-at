package confs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import enums.ConfigParams;

public final class Config {
    private static final Config INSTANCE = new Config();

    private final Properties properties = new Properties();

    private Config() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                throw new RuntimeException("config.properties wasn't found in resources");
            }
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Fail to load config.properties");
        }
    }

    public static String getProperty(ConfigParams configParam) {
        System.out.println("System property: "
                + System.getProperty(configParam.getValue()));

        System.out.println("Env property: "
                + System.getenv(configParam.name()));

        System.out.println("Properties file: "
                + INSTANCE.properties.getProperty(configParam.getValue()));
        var property = System.getProperty(configParam.getValue());
        if (property != null && !property.isBlank()) {
            return property;
        }
        property = System.getenv(configParam.name());
        if (property != null && !property.isBlank()) {
            return property;
        }
        return INSTANCE.properties.getProperty(configParam.getValue());
    }

    public static long getLongProperty(ConfigParams configParam) {
        return Long.parseLong(getProperty(configParam));
    }
}