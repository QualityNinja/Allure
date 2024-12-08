package Homewok_16.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {

            throw new RuntimeException("Ошибка при загрузке файла config.properties: " + e.getMessage());
        }
    }

    public static String get(String key) {

        return properties.getProperty(key);
    }
}
