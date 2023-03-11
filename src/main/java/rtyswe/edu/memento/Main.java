package rtyswe.edu.memento;

import rtyswe.edu.model.Car;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car car = new Car("old brand", 2);
        car.createMemento();
        car.print(System.out);

        System.out.println();
        car.setBrand("new brand");
        car.print(System.out);

        System.out.println();
        car.setMemento();
        car.print(System.out);

    }

}
