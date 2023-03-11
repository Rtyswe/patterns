package rtyswe.edu.template_method;

import javax.swing.*;
import java.awt.*;

public class SquareComponent extends TemplateComponent {

    private final Image image;

    public SquareComponent() {
        image = new ImageIcon("src/main/resources/square.png").getImage();
    }

    @Override
    protected Image getImage() {
        return image;
    }
}
