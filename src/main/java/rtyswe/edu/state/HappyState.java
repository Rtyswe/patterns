package rtyswe.edu.state;

import javax.swing.*;
import java.awt.*;

public class HappyState implements State {
    @Override
    public Image getImage() {
        return new ImageIcon("src/main/resources/radost.png").getImage();
    }
}
