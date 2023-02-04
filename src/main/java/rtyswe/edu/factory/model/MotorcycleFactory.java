package rtyswe.edu.factory.model;

public class MotorcycleFactory implements VehicleFactory {
    @Override
    public Vehicle createInstance(String brand, int size) {
        return new Motorcycle(brand, size);
    }

    @Override
    public Vehicle createInstance() {
        return new Motorcycle();
    }
}
