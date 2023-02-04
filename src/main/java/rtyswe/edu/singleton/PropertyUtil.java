package rtyswe.edu.singleton;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    private static Properties properties = null;
    private static final String FILE_LOCATION = "src/main/resources/";
    private static final String FILE_NAME = "config.properties";

    public static Properties getProperties() {
        if (properties == null) {
            // достать из файла
            try (FileReader fr = new FileReader(FILE_LOCATION + FILE_NAME)) {
                properties = new Properties();
                properties.load(fr);
                System.out.println("Загрузил из файла");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return properties;
    }

}
