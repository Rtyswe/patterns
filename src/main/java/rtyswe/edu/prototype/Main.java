package rtyswe.edu.prototype;

import rtyswe.edu.factory.exeptions.DuplicateModelNameException;
import rtyswe.edu.factory.exeptions.NoSuchModelNameException;
import rtyswe.edu.factory.model.Car;
import rtyswe.edu.factory.model.Motorcycle;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, DuplicateModelNameException, NoSuchModelNameException {
        Car motorcycle = new Car("moto", 2);
        Car cloneMotorcycle = motorcycle.clone();

        cloneMotorcycle.setModelNameByModelName("Model #1", "New");
        System.out.println(motorcycle);
        System.out.println(cloneMotorcycle);

    }

}
