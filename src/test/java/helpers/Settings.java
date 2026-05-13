package helpers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.Map;

public class Settings {
    public static String file = "settings.xml";
    private static Map<String, String> properties;

    static {
        try {
            File configFile = new File(file);
            if (!configFile.exists()) {
                throw new RuntimeException("Файл настроек не найден: " + file);
            }
            XmlMapper mapper = new XmlMapper();
            properties = mapper.readValue(configFile, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при чтении настроек из XML", e);
        }
    }

    public static String getBaseUrl() {
        return properties.get("baseUrl");
    }

    public static String getLogin() {
        return properties.get("login");
    }

    public static String getPassword() {
        return properties.get("password");
    }
}