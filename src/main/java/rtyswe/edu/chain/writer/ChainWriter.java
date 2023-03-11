package rtyswe.edu.chain.writer;

import rtyswe.edu.model.Vehicle;

import java.util.function.Predicate;

public abstract class ChainWriter {
    private ChainWriter next;
    private Predicate<Vehicle> predicate;

    public void setNext(ChainWriter next) {
        this.next = next;
    }

    public void setPredicate(Predicate<Vehicle> predicate) {
        this.predicate = predicate;
    }

    public void writeVehicle(String filename, Vehicle vehicle) {
        if (predicate.test(vehicle)) {
            write(filename, vehicle);
            return;
        }

        if (next != null) {
            next.writeVehicle(filename, vehicle);
        }
    }

    protected abstract void write(String filename, Vehicle vehicle);
}
