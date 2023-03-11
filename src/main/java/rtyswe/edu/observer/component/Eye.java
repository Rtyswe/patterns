package rtyswe.edu.observer.component;

import java.awt.*;

public class Eye implements Observer {
    
    private final int x, y;
    private State state;
    private final int radius = 25;

    public Eye(int x, int y) {
        this.x = x;
        this.y = y;
        state = State.OPEN;
    }

    enum State {
        OPEN, CLOSED
    }
    
    @Override
    public boolean test(int x, int y) {
        int centerX = this.x + radius;
        int centerY = this.y + radius;
        return Math.pow(centerX - x, 2) + Math.pow(centerY - y, 2) <= Math.pow(radius, 2);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setStroke(new BasicStroke(5));
        if (state == State.OPEN) {
            g2D.setPaint(Color.WHITE);
            g2D.fillOval(x, y, radius*2, radius*2);
            g2D.setPaint(Color.BLACK);
            g2D.drawOval(x, y, radius*2, radius*2);
        } else {
            g2D.setPaint(Color.BLACK);
            g2D.drawLine(x, y + radius, x + 2*radius, y + radius);
        }
    }

    @Override
    public void update() {
        if (state == State.OPEN) {
            state = State.CLOSED;
        } else {
            state = State.OPEN;
        }
    }
}
