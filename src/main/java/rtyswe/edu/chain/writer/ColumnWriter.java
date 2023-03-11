package rtyswe.edu.chain.writer;

import rtyswe.edu.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ColumnWriter extends ChainWriter {
    @Override
    protected void write(String filename, Vehicle vehicle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Brand: ").append(vehicle.getBrand()).append('\n');

            int length = vehicle.getSize();
            String[] modelNames = vehicle.getModelNames();
            double[] modelPrices = vehicle.getModelPrices();
            for (int i = 0; i < length-1; ++i) {
                sb.append(modelNames[i]).append(" - ").append(modelPrices[i]).append(";\n");
            }
            sb.append(modelNames[length-1]).append(" - ").append(modelPrices[length-1]).append(".\n");

            writer.write(sb.toString());

        } catch (IOException ignored) {}
    }
}
