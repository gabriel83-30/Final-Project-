package propertyUtility;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
//    public Properties properties;
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties nu a putut fi citit!");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }


}



