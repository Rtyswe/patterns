package rtyswe.edu.template_method;

import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class TemplateComponent {

    private int x = 0, y = 0;
    private int xVelocity = 5, yVelocity = 10;
    protected abstract Image getImage();

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(getImage(), x, y, 50, 50, null);
    }

    public void actionPerformed(ActionEvent e) {
        if (x >= 450 || x < 0) {
            xVelocity *= -1;
        }

        if (y >= 450 || y < 0) {
            yVelocity *= -1;
        }

        x += xVelocity;
        y += yVelocity;
    }

}
