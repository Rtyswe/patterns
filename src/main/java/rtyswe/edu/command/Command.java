package rtyswe.edu.command;

import rtyswe.edu.model.Vehicle;

import java.io.OutputStream;

public interface Command {

    void print(Vehicle vehicle, OutputStream os);

}
