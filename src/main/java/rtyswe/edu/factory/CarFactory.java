package rtyswe.edu.factory;

import rtyswe.edu.model.Car;
import rtyswe.edu.model.Vehicle;

public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createInstance(String brand, int size) {
        return new Car(brand, size);
    }

    @Override
    public Vehicle createInstance() {
        return new Car();
    }
}
