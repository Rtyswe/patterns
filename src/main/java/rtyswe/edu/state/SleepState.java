package rtyswe.edu.state;

import javax.swing.*;
import java.awt.*;

public class SleepState implements State {

    @Override
    public Image getImage() {
        return new ImageIcon("src/main/resources/spit.png").getImage();
    }
}
