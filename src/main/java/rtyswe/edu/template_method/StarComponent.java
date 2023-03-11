package rtyswe.edu.template_method;

import javax.swing.*;
import java.awt.*;

public class StarComponent extends TemplateComponent {

    private final Image image;

    public StarComponent() {
        image = new ImageIcon("src/main/resources/star.jpg").getImage();
    }

    @Override
    protected Image getImage() {
        return image;
    }
}
