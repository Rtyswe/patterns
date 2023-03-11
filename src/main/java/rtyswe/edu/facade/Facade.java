package rtyswe.edu.facade;

import java.awt.*;

public class Facade {
    private final MyPanel panel;
    private final Car car;
    private final TrafficLight trafficLight;

    public Facade(MyPanel panel) {
        this.panel = panel;
        car = new Car(this);
        trafficLight = new TrafficLight(this);
    }

    public void paint(Graphics g) {
        if (trafficLight.getLight() == TrafficLight.Light.RED && car.getXCoords() > 300 && car.getXCoords() < 350) {
            car.setVelocity(0);
        } else {
            car.setVelocity(-20);
        }
        car.paint(g);
        trafficLight.paint(g);
    }

    public void repaint() {
        panel.repaint();
    }
}
