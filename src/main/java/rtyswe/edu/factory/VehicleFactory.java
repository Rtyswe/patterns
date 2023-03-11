package rtyswe.edu.factory;

import rtyswe.edu.model.Vehicle;

public interface VehicleFactory {
    Vehicle createInstance(String brand, int size);
    Vehicle createInstance();
}
