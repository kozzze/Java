import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Runner extends Thread {
    private final JProgressBar bar;
    private final String name;
    private static final long startTime = System.currentTimeMillis();
    public static volatile boolean finished = false;

    public Runner(JProgressBar bar, String name) {
        this.bar = bar;
        this.name = name;
    }

    @Override
    public void run() {
        int value = 0;

        while (value <= 100 && !finished) {
            bar.setValue(value);
            log("Прогресс: " + value + "%");
            value += (int) (Math.random() * 10);

            try {
                Thread.sleep((int) (Math.random() * 150));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!finished) {
            finished = true;
            log("🏁 Победил!");
            showFireworks();
        } else {
            log("Финишировал позже");
        }
    }

    private void log(String message) {
        long time = System.currentTimeMillis() - startTime;
        String entry = "[" + name + "] " + time + "ms - " + message;
        System.out.println(entry);
        try (PrintWriter out = new PrintWriter(new FileWriter("race_log.txt", true))) {
            out.println(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFireworks() {
        ImageIcon fireworksIcon = new ImageIcon("/Users/kozzze/Desktop/Учеба/Java/java/lab6/salut.gif");
        JOptionPane.showMessageDialog(null,
                name + " победил!",
                "Победа!",
                JOptionPane.INFORMATION_MESSAGE,
                fireworksIcon);
    }
}