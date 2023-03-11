package rtyswe.edu.observer;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        MyPanel panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
