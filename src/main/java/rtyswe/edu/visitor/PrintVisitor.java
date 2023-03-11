package rtyswe.edu.visitor;

import rtyswe.edu.model.Car;
import rtyswe.edu.model.Motorcycle;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Car car) {
        String[] names = car.getModelNames();
        double[] prices = car.getModelPrices();

        StringBuilder sb = new StringBuilder();
        sb.append("Brand: ").append(car.getBrand()).append('\n');
        for (int i = 0; i < car.getSize(); ++i) {
            sb.append(names[i]).append(" - ").append(prices[i]).append(";\t");
        }
        System.out.println(sb);
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        String[] names = motorcycle.getModelNames();
        double[] prices = motorcycle.getModelPrices();

        StringBuilder sb = new StringBuilder();
        sb.append("Brand: ").append(motorcycle.getBrand()).append('\n');
        for (int i = 0; i < motorcycle.getSize(); ++i) {
            sb.append(names[i]).append(" - ").append(prices[i]).append(";\n");
        }
        System.out.println(sb);
    }
}
