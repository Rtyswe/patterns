package rtyswe.edu.visitor;

import rtyswe.edu.model.Car;
import rtyswe.edu.model.Motorcycle;

public interface Visitor {
    void visit(Car car);
    void visit(Motorcycle motorcycle);
}
