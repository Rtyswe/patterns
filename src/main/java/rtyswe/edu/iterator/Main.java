package rtyswe.edu.iterator;

import rtyswe.edu.model.Car;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("bmw", 5);
        Iterator iterator = car.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
