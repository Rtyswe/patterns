package rtyswe.edu.factory.model;

public interface VehicleFactory {
    Vehicle createInstance(String brand, int size);
    Vehicle createInstance();
}
