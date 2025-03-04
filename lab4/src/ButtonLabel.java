import javax.swing.*;
import java.awt.*;

public class ButtonLabel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Моё окно");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Кнопка 1");
        JButton button2 = new JButton("Кнопка 2");
        JButton button3 = new JButton("Кнопка 3");

        JLabel label1 = new JLabel("Я метка 1");
        JLabel label2 = new JLabel("Я метка 2");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(label1);
        panel.add(label2);

        frame.add(panel);

        frame.setVisible(true);
    }
}