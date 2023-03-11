package rtyswe.edu.facade;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private final int WIDTH = 700;
    private final int HEIGHT = 500;

    private final Facade facade;

    public MyPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.gray);

        facade = new Facade(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        facade.paint(g);
    }
}
