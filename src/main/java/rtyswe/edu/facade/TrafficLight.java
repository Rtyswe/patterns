package rtyswe.edu.facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TrafficLight {

    private final Image image;

    private final int xCoords;
    private final int yCoords;

    private int lightVelocity;

    private Light light;
    private final Facade facade;

    enum Light {
        GREEN(Color.GREEN, 190),
        YELLOW(Color.YELLOW, 175),
        RED(Color.RED, 157);

        final Color color;
        final int coords;
        Light(Color color, int coords) {
            this.color = color;
            this.coords = coords;
        }

        Color getColor() {
            return color;
        }

        public int getCoords() {
            return coords;
        }
    }

    public TrafficLight(Facade facade) {
        light = Light.GREEN;
        image = new ImageIcon("src/main/resources/light.png").getImage();
        xCoords = 300;
        yCoords = 150;

        this.facade = facade;

        Timer timer = new Timer(1000, this::actionPerformed);
        timer.start();
    }

    public Light getLight() {
        return light;
    }

    public void actionPerformed(ActionEvent e) {
        if (light == Light.GREEN) {
            lightVelocity = 1;
        } else if (light == Light.RED) {
            lightVelocity = -1;
        }

        light = Light.values()[light.ordinal() + lightVelocity];
        facade.repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(light.getColor());
        g2D.fillRect(xCoords + 17, light.getCoords(), 15, 15);
        g2D.drawImage(image, xCoords, yCoords, null);
    }
}
