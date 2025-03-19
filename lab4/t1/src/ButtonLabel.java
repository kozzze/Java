import javax.swing.*;
import java.awt.*;

public class ButtonLabel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Моё окно");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Синий");
        JButton button2 = new JButton("Крайный");
        JButton button3 = new JButton("Зеленый");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        button1.addActionListener(new ColorAction(panel, Color.blue));
        button2.addActionListener(new ColorAction(panel, Color.red));
        button3.addActionListener(new ColorAction(panel, Color.green));

        frame.add(panel);

        frame.setVisible(true);


    }
}