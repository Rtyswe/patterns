package rtyswe.edu.observer.component;

import java.awt.*;

public interface Observer {

    boolean test(int x, int y);
    void paint(Graphics g);
    void update();

}
