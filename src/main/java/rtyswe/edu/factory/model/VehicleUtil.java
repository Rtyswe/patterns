package rtyswe.edu.factory.model;

import rtyswe.edu.factory.exeptions.DuplicateModelNameException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class VehicleUtil {

    private static VehicleFactory factory = new CarFactory();

    private VehicleUtil() {}

    public static void setVehicleFactory(VehicleFactory vehicleFactory) {
        factory = vehicleFactory;
    }

    public static double getAverage(Vehicle vehicle) {
        return Arrays.stream(vehicle.getModelPrices()).average().orElse(-1.);
    }

    public static void printModelNames(Vehicle vehicle) {
        System.out.println(Arrays.toString(vehicle.getModelNames()));
    }

    public static void printModelPrices(Vehicle vehicle) {
        System.out.println(Arrays.toString(vehicle.getModelPrices()));
    }

    public static Vehicle createInstance(String brand, int size) {
        return factory.createInstance(brand, size);
    }

    public static void writeVehicleToByteStream(Vehicle vehicle, OutputStream outputStream) throws IOException {
        try(DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            dataOutputStream.writeInt(vehicle.getBrand().getBytes().length);
            dataOutputStream.write(vehicle.getBrand().getBytes());
            dataOutputStream.writeInt(vehicle.getSize());
            String [] modelNames = vehicle.getModelNames();
            double [] modelPrices = vehicle.getModelPrices();
            for(int i = 0; i < vehicle.getSize(); i++) {
                dataOutputStream.writeInt(modelNames[i].getBytes().length);
                dataOutputStream.write(modelNames[i].getBytes());
                dataOutputStream.writeDouble(modelPrices[i]);
            }
        }
    }

    public static Vehicle readVehicleFromByteStream(InputStream inputStream) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, DuplicateModelNameException {
        try(DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            Vehicle vehicle = factory.createInstance();
            int bytes = dataInputStream.readInt();
            vehicle.setBrand(new String(dataInputStream.readNBytes(bytes)));
            int size = dataInputStream.readInt();
            for(int i = 0; i < size; i++) {
                bytes = dataInputStream.readInt();
                vehicle.addModel(new String(dataInputStream.readNBytes(bytes)), dataInputStream.readDouble());
            }
            return vehicle;
        }
    }

    public static void writeVehicleToCharStream(Vehicle vehicle, Writer writer) {
        try(PrintWriter printWriter = new PrintWriter(writer)) {
            printWriter.println(vehicle.getBrand());
            printWriter.println(vehicle.getSize());
            String [] modelNames = vehicle.getModelNames();
            double [] modelPrices = vehicle.getModelPrices();
            for(int i = 0; i < vehicle.getSize(); i++) {
                printWriter.println(modelNames[i]);
                printWriter.println(modelPrices[i]);
            }
        }
    }

    public static Vehicle readVehicleFromCharStream(Reader reader) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, DuplicateModelNameException {
        try(BufferedReader bufferedReader = new BufferedReader(reader)) {
            Vehicle vehicle = factory.createInstance();
            vehicle.setBrand(bufferedReader.readLine());
            int size = Integer.parseInt(bufferedReader.readLine());
            for(int i = 0; i < size; i++) {
                vehicle.addModel(bufferedReader.readLine(), Double.parseDouble(bufferedReader.readLine()));
            }
            return vehicle;
        }
    }

    public static void serializeVehicle(Vehicle vehicle, OutputStream outputStream) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(vehicle);
        }
    }

    public static Vehicle deserializeVehicle(InputStream inputStream) throws IOException, ClassNotFoundException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (Vehicle) objectInputStream.readObject();
        }
    }
}
