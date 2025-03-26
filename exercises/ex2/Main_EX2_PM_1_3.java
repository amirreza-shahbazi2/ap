package exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_3 {
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
        int p = 0;
        while (p < c) {
            int row = rand.nextInt(k) + 1;
            int col = rand.nextInt(k) + 1;
            if (board[row][col] == ' ') {
                board[row][col] = '.';
                p++;
            }
        }
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
