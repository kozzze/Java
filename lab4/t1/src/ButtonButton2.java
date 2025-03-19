import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonButton2 extends JFrame implements ActionListener {
    private JPanel panel;

    public void ButtonButton() {
        setTitle("Изменение цвета панели");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Синий");
        JButton button2 = new JButton("Красный");
        JButton button3 = new JButton("Зеленый");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        // Добавляем слушателя событий (this)
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Синий")) {
            panel.setBackground(Color.BLUE);
        } else if (command.equals("Красный")) {
            panel.setBackground(Color.RED);
        } else if (command.equals("Зеленый")) {
            panel.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new ButtonButton2().setVisible(true); //
    }
}