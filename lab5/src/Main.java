import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Гонки!");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1)); // 3 прогресс-бара + кнопка

        // Прогресс-бары для гонщиков
        JProgressBar bar1 = new JProgressBar(0, 100);
        JProgressBar bar2 = new JProgressBar(0, 100);
        JProgressBar bar3 = new JProgressBar(0, 100);

        // Кнопка запуска
        JButton startButton = new JButton("СТАРТ");

        // Добавление компонентов в окно
        frame.add(bar1);
        frame.add(bar2);
        frame.add(bar3);
        frame.add(startButton);

        // Обработчик кнопки СТАРТ
        startButton.addActionListener(e -> {
            // Сброс значений и флага победы
            bar1.setValue(0);
            bar2.setValue(0);
            bar3.setValue(0);
            Runner.finished = false;

            // Запуск потоков
            new Runner(bar1, "Игрок 1").start();
            new Runner(bar2, "Игрок 2").start();
            new Runner(bar3, "Игрок 3").start();
        });

        frame.setVisible(true);
    }
}