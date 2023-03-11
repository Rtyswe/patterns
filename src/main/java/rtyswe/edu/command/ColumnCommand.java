package rtyswe.edu.command;

import rtyswe.edu.model.Vehicle;

import java.io.*;

public class ColumnCommand implements Command {
    @Override
    public void print(Vehicle vehicle, OutputStream os) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Brand: ").append(vehicle.getBrand()).append('\n');

            int length = vehicle.getSize();
            String[] modelNames = vehicle.getModelNames();
            double[] modelPrices = vehicle.getModelPrices();
            for (int i = 0; i < length; ++i) {
                sb.append(modelNames[i]).append(" - ").append(modelPrices[i]).append(";\n");
            }

            os.write(sb.toString().getBytes());
        } catch (IOException ignored) {}
    }
}
