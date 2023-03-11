package rtyswe.edu.state;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyPanel extends JPanel {

    private final int WIDTH = 1400;
    private final int HEIGHT = 700;

    private State state = new SleepState();

    public MyPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JButton sleepButton = new JButton("Семестр");
        sleepButton.addActionListener(this::sleepActionPerformed);
        this.add(sleepButton);

        JButton happyButton = new JButton("Каникулы");
        happyButton.addActionListener(this::happyActionPerformed);
        this.add(happyButton);

        JButton sadButton = new JButton("Сессия");
        sadButton.addActionListener(this::sadActionPerformed);
        this.add(sadButton);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(state.getImage(), 0, 40, 1400, 660, null);
    }

    private void setState(State state) {
        this.state = state;
    }

    public void sadActionPerformed(ActionEvent e) {
        setState(new SadState());
        repaint();
    }

    public void happyActionPerformed(ActionEvent e) {
        setState(new HappyState());
        repaint();
    }

    public void sleepActionPerformed(ActionEvent e) {
        setState(new SleepState());
        repaint();
    }
}
