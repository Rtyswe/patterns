package rtyswe.edu.state;

import javax.swing.*;
import java.awt.*;

public class SadState implements State {
    @Override
    public Image getImage() {
        return new ImageIcon("src/main/resources/grust.png").getImage();
    }
}
