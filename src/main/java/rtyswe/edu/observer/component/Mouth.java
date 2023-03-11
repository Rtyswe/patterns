package rtyswe.edu.observer.component;

import java.awt.*;

public class Mouth implements Observer {

    private final int x, y;
    private final int width = 50;
    private final int height = 20;
    private State state;

    public Mouth(int x, int y) {
        this.x = x;
        this.y = y;
        state = State.NO_SMILE;
    }

    private enum State {
        SMILE,
        NO_SMILE
    }

    @Override
    public boolean test(int x, int y) {
        return x <= this.x + width && x >= this.x && y >= this.y - height && y <= this.y;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(5));
        if (state == State.SMILE) {
            g2D.drawArc(x, y - height, width, height, 0, -180);
        } else {
            g2D.drawLine(x, y, x + width, y);
        }
    }

    @Override
    public void update() {
        if (state == State.SMILE) {
            state = State.NO_SMILE;
        } else {
            state = State.SMILE;
        }
    }
}
