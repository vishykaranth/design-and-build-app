package lamdba;

import javax.swing.*;
import java.awt.*;

public class ListenerTest {
    public static void main(String[] args) {
        JButton button = new JButton("Test Button");
        button.addActionListener(e -> System.out.println("Button Clicked"));

        JFrame frame = new JFrame("Listener Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
