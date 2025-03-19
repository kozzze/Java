import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonClass extends JFrame {
    private JPanel panel; // Объявляем панель глобально, чтобы её видел вложенный класс

    public ButtonClass() {
        // Настройки окна
        setTitle("Изменение цвета панели");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём панель
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Синий");
        JButton button2 = new JButton("Красный");
        JButton button3 = new JButton("Зеленый");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        button1.addActionListener(new ColorAction(Color.BLUE));
        button2.addActionListener(new ColorAction(Color.RED));
        button3.addActionListener(new ColorAction(Color.GREEN));

        add(panel);
        setVisible(true);
    }

    private class ColorAction implements ActionListener {
        private Color color;

        public ColorAction(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(color);
        }
    }

    public static void main(String[] args) {
        new ButtonClass();
    }
}