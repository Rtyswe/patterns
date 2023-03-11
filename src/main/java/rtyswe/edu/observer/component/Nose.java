package rtyswe.edu.observer.component;

import java.awt.*;

public class Nose implements Observer {

    private final int[] xCoords;
    private final int[] yCoords;
    private State state;

    public Nose(int x, int y) {
        int sideLength = 30;
        xCoords = new int[]{x, x+ sideLength /2, x+ sideLength};
        yCoords = new int[]{y + sideLength, y, y+ sideLength};
        state = State.BLACK;
    }

    private enum State {
        BLACK(Color.BLACK),
        GREEN(Color.GREEN),
        RED(Color.RED);
        private final Color color;

        State(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    @Override
    public boolean test(int x, int y) {
        int arg1 = (xCoords[0] - x) * (yCoords[1] - yCoords[0]) - (xCoords[1] - xCoords[0]) * (yCoords[0] - y);
        int arg2 = (xCoords[1] - x) * (yCoords[2] - yCoords[1]) - (xCoords[2] - xCoords[1]) * (yCoords[1] - y);
        int arg3 = (xCoords[2] - x) * (yCoords[0] - yCoords[2]) - (xCoords[0] - xCoords[2]) * (yCoords[2] - y);
        return (arg1 < 0 && arg2 < 0 && arg3 < 0) || (arg1 > 0 && arg2 > 0 && arg3 > 0);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(state.getColor());
        g2D.fillPolygon(xCoords, yCoords, 3);
    }

    @Override
    public void update() {
        if (state == State.BLACK) {
            state = State.GREEN;
        } else if (state == State.GREEN) {
            state = State.RED;
        } else {
            state = State.BLACK;
        }
    }
}
