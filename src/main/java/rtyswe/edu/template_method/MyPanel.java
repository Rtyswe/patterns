package rtyswe.edu.template_method;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyPanel extends JPanel {

    List<TemplateComponent> components = new ArrayList<>();

    public MyPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.gray);

        JButton newComponentButton = new JButton("Пуск");
        newComponentButton.addActionListener(this::newComponentActionPerformed);
        this.add(newComponentButton);

        JButton exitButton = new JButton("Закрыть");
        exitButton.addActionListener(this::exitButtonActionEvent);
        this.add(exitButton);

        new Timer(10, this::paint).start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (TemplateComponent component: components) {
            component.paint(g);
        }
    }

    public void paint(ActionEvent e) {
        repaint();
    }

    public void exitButtonActionEvent(ActionEvent e) {
        System.exit(0);
    }

    public void newComponentActionPerformed(ActionEvent e) {
        TemplateComponent component;
        Random random = new Random();
        int num = random.nextInt() % 3;
        if (num == 0) {
            component = new BallComponent();
        } else if (num == 1) {
            component = new StarComponent();
        } else {
            component = new SquareComponent();
        }

        components.add(component);

        new Thread(new ComponentRunnable(component)).start();
    }
}