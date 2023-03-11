package rtyswe.edu.factory;

import rtyswe.edu.model.Vehicle;
import rtyswe.edu.model.VehicleUtil;

public class Main {

    public static void main(String[] args) {
        Vehicle cars = VehicleUtil.createInstance("cars", 2);
        System.out.println(cars);
        System.out.println(cars.getClass());
        VehicleUtil.printModelNames(cars);
        VehicleUtil.printModelPrices(cars);
        System.out.println(VehicleUtil.getAverage(cars));

        System.out.println("\n\n\n");

        VehicleUtil.setVehicleFactory(new MotorcycleFactory());
        Vehicle moto = VehicleUtil.createInstance("moto", 3);
        System.out.println(moto);
        System.out.println(moto.getClass());
        VehicleUtil.printModelNames(moto);
        VehicleUtil.printModelPrices(moto);
        System.out.println(VehicleUtil.getAverage(moto));
    }

}
