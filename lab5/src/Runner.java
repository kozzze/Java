import javax.swing.*;

public class Runner extends Thread {
    private final JProgressBar bar;
    private final String name;

    // Общий флаг для всех потоков, чтобы остановить после победы
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
            value += (int)(Math.random() * 10); // случайный шаг

            try {
                Thread.sleep((int)(Math.random() * 150)); // случайная задержка
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!finished) {
            finished = true;
            JOptionPane.showMessageDialog(null, name + " победил!");
        }
    }
}