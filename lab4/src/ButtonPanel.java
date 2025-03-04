import javax.swing.*;
import java.awt.*;

public class ButtonPanel {
    public static void main(String[] args) {
        // Создаём главное окно
        JFrame frame = new JFrame("Окно с кнопками");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём панель
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Размещение кнопок по умолчанию (в строку)

        // Создаём 9 кнопок
        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("Кнопка " + i)); // Добавляем кнопку на панель
        }

        // Добавляем панель в окно
        frame.add(panel);

        // Делаем окно видимым
        frame.setVisible(true);
    }
}