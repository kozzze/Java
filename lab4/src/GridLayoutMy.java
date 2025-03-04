import javax.swing.*;
import java.awt.*;

public class GridLayoutMy {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Окно с кнопками");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2)); // 2 строки, 2 столбца

        // Создаём кнопки
        JButton button1 = new JButton("Кнопка 1");
        JButton button2 = new JButton("Кнопка 2");
        JButton button3 = new JButton("Кнопка 3");
        JButton button4 = new JButton("Кнопка 4");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        frame.add(panel);
        frame.setVisible(true);
    }
}