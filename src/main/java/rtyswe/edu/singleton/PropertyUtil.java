package rtyswe.edu.singleton;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PropertyUtil {

    private static Properties properties = null;
    private static final String FILE_LOCATION = "src/main/resources/";
    private static final String FILE_NAME = "config.properties";

    private static final Lock locker = new ReentrantLock();

    private PropertyUtil() {}

    public static Properties getProperties() {
        if (properties == null) {
            // достать из файла
            locker.lock();
            if (properties != null) {
                locker.unlock();
                return properties;
            }
            try (FileReader fr = new FileReader(FILE_LOCATION + FILE_NAME)) {
                properties = new Properties();
                properties.load(fr);
                System.out.println("Загрузил из файла");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                locker.unlock();
            }
        }

        return properties;
    }

}
