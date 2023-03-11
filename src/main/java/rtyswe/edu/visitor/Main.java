package rtyswe.edu.visitor;

import rtyswe.edu.model.Car;
import rtyswe.edu.model.Motorcycle;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("car", 3);
        Motorcycle moto = new Motorcycle("moto", 3);

        Visitor visitor = new PrintVisitor();
        car.accept(visitor);
        moto.accept(visitor);
    }

}
