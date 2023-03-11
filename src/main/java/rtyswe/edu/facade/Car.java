package rtyswe.edu.facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Car {

    private final Image image;
    private int velocity;
    private int xCoords;
    private final int yCoords;

    private final Facade facade;

    public Car(Facade facade) {
        image = new ImageIcon("src/main/resources/car.png").getImage();
        velocity = -2;
        xCoords = 700;
        yCoords = 200;
        this.facade = facade;

        Timer timer = new Timer(7, this::actionPerformed);
        timer.start();
    }

    public int getXCoords() {
        return xCoords;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getVelocity() {
        return velocity;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image, xCoords, yCoords, null);
    }

    public void actionPerformed(ActionEvent e) {
        if (xCoords < -image.getWidth(null)) {
            xCoords = 700;
        }
        xCoords += velocity;
        facade.repaint();
    }
}
