package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static Properties configProp;
    public static String propertiesFilePath = "src/main/resources/appConfig.properties";

    public static String getProperty(String key) {
        configProp = new Properties();
        try {
            configProp.load(new FileInputStream(propertiesFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configProp.getProperty(key);
    }

}
