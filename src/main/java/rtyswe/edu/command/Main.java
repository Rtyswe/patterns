package rtyswe.edu.command;

import rtyswe.edu.model.Car;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("mercedes", 2);
        car.print(System.out);
        car.setCommand(new ColumnCommand());
        car.print(System.out);
    }

}
