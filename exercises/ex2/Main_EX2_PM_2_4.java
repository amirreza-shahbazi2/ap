package exercises.ex2;
import java.util.Random;
import java.io.*;

public class Main_EX2_PM_2_4 {

    public static class PacmanEngine {
        private int k;
        private int c;
        private char[][] board;
        private int score;
        private int x;
        private int y;
        private long startTime;
        private int dotscount;
        private final String SAVE_FILE = "pacman_save.txt";

        public PacmanEngine(int k, int c) {
            this.k = k;
            this.c = c;
            mainpartgame();
        }

        private void mainpartgame() {

            board = new char[k + 2][k + 2];
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                        board[i][j] = '*';
                    } else {
                        board[i][j] = ' ';
                    }
                }
            }

            Random rnd = new Random();
            int p = 0;
            while (p < c) {
                int row = rnd.nextInt(k) + 1;
                int col = rnd.nextInt(k) + 1;
                if (board[row][col] == ' ') {
                    board[row][col] = '.';
                    p++;
                }
            }
            dotscount = c;
            x = 1;
            y = 1;
            board[x][y] = 'X';
            startTime = System.currentTimeMillis();
        }

        public void printMatrix() {
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

        public void printScore() {
            System.out.println("Score: " + score);
        }

        public void printRemainTime() {
            long elapsed = System.currentTimeMillis() - startTime;
            System.out.println("Time: " + (elapsed / 1000) + " seconds");
        }

        public void move(int direction) {
            int newx = x;
            int newy = y;

            switch (direction) {
                case 0:
                    newx--;
                    break;
                case 1:
                    newy++;
                    break;
                case 2:
                    newx++;
                    break;
                case 3:
                    newy--;
                    break;
            }
            if (board[newx][newy] == '*') {
                System.out.println("hitting the game wall");
                return;
            }
            if (board[newx][newy] == '.') {
                score++;
                dotscount--;
            }
            board[x][y] = ' ';
            x = newx;
            y = newy;
            board[x][y] = 'X';
        }

        public void save() {
            try (PrintWriter writer = new PrintWriter(SAVE_FILE)) {
                writer.println(k);
                writer.println(c);
                writer.println(score);
                writer.println(x);
                writer.println(y);
                writer.println(startTime);

                for (int i = 0; i < board.length; i++) {
                    writer.println(new String(board[i]));
                }
                System.out.println("Game saved successfully.");
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    public static void main(String[] args) {

        int k = 9; //عدد مربوط به تمرین EX2_PM_1_1 و EX2_PM_1_2
        int c = 15; //عدد مربوط به تمرین EX2_PM_1_3

        Random rnd = new Random();

        PacmanEngine pacmanEngine = new PacmanEngine(k, c);

        while (true) {
            pacmanEngine.printMatrix(); // مربوط به بخش آخر تمرین EX2_PM_1_3
            pacmanEngine.printScore(); // امتیاز تمرین EX2_PM_2_2
            pacmanEngine.printRemainTime(); // زمان تمرین EX2_PM_2_2

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

            int direction = rnd.nextInt(4);
            pacmanEngine.move(direction);// حرکت نقطه خوار مربوط به تمرین EX2-PM.1.5
            pacmanEngine.save();
        }
    }
}

