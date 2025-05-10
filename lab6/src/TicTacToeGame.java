import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class TicTacToeGame {
    private static final char[][] board = new char[3][3];
    private static volatile boolean gameEnded = false;
    private static final Object lock = new Object();
    private static final long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        // очистим лог перед запуском
        try (PrintWriter out = new PrintWriter("log.txt")) {
            out.print(""); // очищаем
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }

        Thread player1 = new Thread(new Player('X', "1-й поток"));
        Thread player2 = new Thread(new Player('O', "2-й поток"));

        player1.start();
        player2.start();
    }

    static class Player implements Runnable {
        private final char symbol;
        private final String name;
        private final Random rand = new Random();

        public Player(char symbol, String name) {
            this.symbol = symbol;
            this.name = name;
        }

        @Override
        public void run() {
            while (!gameEnded) {
                synchronized (lock) {
                    if (gameEnded) return;

                    int row, col;
                    do {
                        row = rand.nextInt(3);
                        col = rand.nextInt(3);
                    } while (board[row][col] != ' ');

                    board[row][col] = symbol;
                    log("Ход: " + symbol + " (" + row + ", " + col + ")");
                    printBoard();

                    if (checkWin(symbol)) {
                        System.out.println(name + " выиграл!");
                        gameEnded = true;
                        return;
                    }

                    if (isBoardFull()) {
                        System.out.println("Ничья!");
                        gameEnded = true;
                        return;
                    }
                }

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            log("окончил!");
        }

        private void log(String message) {
            long timestamp = System.currentTimeMillis() - startTime;
            String logLine = "[" + name + "] " + timestamp + "ms - " + message;
            System.out.println(logLine);
            try (PrintWriter out = new PrintWriter(new FileWriter("log.txt", true))) {
                out.println(logLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void printBoard() {
            for (char[] row : board) {
                for (char cell : row) {
                    System.out.print("|" + cell);
                }
                System.out.println("|");
            }
            System.out.println();
        }

        private boolean checkWin(char symbol) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                        (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol))
                    return true;
            }
            return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
        }

        private boolean isBoardFull() {
            for (char[] row : board) {
                for (char cell : row) {
                    if (cell == ' ') return false;
                }
            }
            return true;
        }
    }
}