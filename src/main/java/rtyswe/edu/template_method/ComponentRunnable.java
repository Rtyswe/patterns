package rtyswe.edu.template_method;

import javax.swing.*;

public class ComponentRunnable implements Runnable {

    private final TemplateComponent component;

    public ComponentRunnable(TemplateComponent component) {
        this.component = component;
    }

    @Override
    public void run() {
        new Timer(10, component::actionPerformed).start();
    }
}
