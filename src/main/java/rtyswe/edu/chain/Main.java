package rtyswe.edu.chain;

import rtyswe.edu.chain.writer.ChainWriter;
import rtyswe.edu.chain.writer.WriterUtils;
import rtyswe.edu.model.Car;
import rtyswe.edu.model.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car("audi", 2);
        ChainWriter writer = WriterUtils.getWriter();
        writer.writeVehicle("output.txt", vehicle);
    }

}
