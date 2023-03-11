package rtyswe.edu.observer;

import rtyswe.edu.observer.component.Eye;
import rtyswe.edu.observer.component.Mouth;
import rtyswe.edu.observer.component.Nose;
import rtyswe.edu.observer.component.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel implements MouseListener {

    private final int WIDTH = 300;
    private final int HEIGHT = 300;

    List<Observer> observers = new ArrayList<>();

    public MyPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.cyan);
        this.addMouseListener(this);

        observers.add(new Mouth(130, 200));
        observers.add(new Eye(100, 100)); // левый глаз
        observers.add(new Eye(160, 100)); // правый глаз
        observers.add(new Nose(140, 150)); // нос

    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.YELLOW);
        g2D.fillOval(55, 50, 200, 200);

        for (Observer observer: observers) {
            observer.paint(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean flag = false;
        for (Observer observer: observers) {
            if (observer.test(e.getX(), e.getY())) {
                observer.update();
                flag = true;
                break;
            }
        }
        if (flag) {
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
