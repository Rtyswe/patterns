package rtyswe.edu.factory.model;

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
