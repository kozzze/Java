import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Гонки!");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1)); // 3 прогресс-бара + кнопка

        JProgressBar bar1 = new JProgressBar(0, 100);
        JProgressBar bar2 = new JProgressBar(0, 100);
        JProgressBar bar3 = new JProgressBar(0, 100);

        JButton startButton = new JButton("СТАРТ");

        frame.add(bar1);
        frame.add(bar2);
        frame.add(bar3);
        frame.add(startButton);

        startButton.addActionListener(e -> {
            try (PrintWriter clear = new PrintWriter("race_log.txt")) {
                clear.print("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            bar1.setValue(0);
            bar2.setValue(0);
            bar3.setValue(0);
            Runner.finished = false;

            new Runner(bar1, "Игрок 1").start();
            new Runner(bar2, "Игрок 2").start();
            new Runner(bar3, "Игрок 3").start();
        });

        frame.setVisible(true);
    }
}