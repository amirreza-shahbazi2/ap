package exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int k = sc.nextInt();
        char[][] board = new char[k + 2][k + 2];

        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    board[i][j] = '*';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
        System.out.println("Enter number less than " + k * k);
        int c = sc.nextInt();
        while (c > (k * k)) {
            System.out.println("Invalid number");
            System.out.println("Enter number less than " + k * k);
            c = sc.nextInt();
        }
        Random rand = new Random();
        int score = 0;
        int dotscount =c;
        int p = 0;

        while (p < c) {
            int row = rand.nextInt(k) + 1;
            int col = rand.nextInt(k) + 1;
            if (board[row][col] == ' ') {
                board[row][col] = '.';
                p++;
            }
        }
        int x = 1, y = 1;
        board[x][y] = 'X';

        Long start = System.currentTimeMillis();
        while (true) {
            System.out.println("Enter a character(w/a/s/d/q)");
            char ch = sc.next().charAt(0);
            switch (ch) {
                case 'w':
                    System.out.println("UP");
                    break;
                case 's':
                    System.out.println("DOWN");
                    break;
                case 'a':
                    System.out.println("LEFT");
                    break;
                case 'd':
                    System.out.println("RIGHT");
                    break;
                case 'q':
                    System.out.println("EXIT");
                    System.exit(0);
                default:
                    System.out.println("WARNING");
            }
            int newx = x, newy = y;
            switch (ch) {
                case 'w':
                    newx--;
                    break;
                case 'd':
                    newy++;
                    break;
                case 's':
                    newx++;
                    break;
                case 'a':
                    newy--;
                    break;
            }
            if (board[newx][newy] == '*') {
                System.out.println("hitting the game wall");
            } else {
                if (board[newx][newy] == '.') {
                    score++;
                    dotscount--;
                }
                board[x][y] = ' ';
                x = newx;
                y = newy;
                board[x][y] = 'X';

                for (int i = 0; i < k + 2; i++) {
                    for (int j = 0; j < k + 2; j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }
                if (dotscount == 0) {
                    Long finish = System.currentTimeMillis();
                    Long timeElapsed = finish - start;
                    System.out.println("Time elapsed: " + (timeElapsed/1000)+" seconds");
                    System.out.println("Score: " + score);
                    System.exit(0);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
