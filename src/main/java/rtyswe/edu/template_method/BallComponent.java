package rtyswe.edu.template_method;

import javax.swing.*;
import java.awt.*;

public class BallComponent extends TemplateComponent {

    private final Image image;

    public BallComponent() {
        image = new ImageIcon("src/main/resources/ball.png").getImage();
    }

    @Override
    protected Image getImage() {
        return image;
    }
}
