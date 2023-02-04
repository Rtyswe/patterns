package rtyswe.edu.singleton;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties properties1 = PropertyUtil.getProperties();
        System.out.println(properties1);
        Properties properties2 = PropertyUtil.getProperties();
        System.out.println(properties2);
        Properties properties3 = PropertyUtil.getProperties();
        System.out.println(properties3);
    }

}
