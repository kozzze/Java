import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonFour extends JFrame {
    private JPanel panel;

    public ButtonFour() {
        // Настройки окна
        setTitle("Изменение цвета панели");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём панель
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Создаём кнопки
        JButton button1 = new JButton("Синий");
        JButton button2 = new JButton("Красный");
        JButton button3 = new JButton("Зеленый");

        // Добавляем кнопки на панель
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        // Используем анонимный класс для обработки событий
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.RED);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.GREEN);
            }
        });

        // Добавляем панель в окно
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonFour(); // Запускаем приложение
    }
}