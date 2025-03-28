package exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int k = sc.nextInt();
        char[][] board= new char[k + 2][k + 2];

        for(int i=0; i<k+2; i++) {
            for (int j = 0; j < k+2; j++) {
                if (i == 0 || i == k+1 || j == 0 || j==k+1) {
                    board[i][j] = '*';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
        Random rand = new Random();
        int x=1, y=1;
        board[x][y]= 'X';
        while (true) {
            int direct = rand.nextInt(4);
            String r = " ";
            switch (direct) {
                case 0:
                    r = "UP";
                    break;
                case 1:
                    r = "RIGHT";
                    break;
                case 2:
                    r = "DOWN";
                    break;
                case 3:
                    r = "LEFT";
                    break;
            }
            System.out.println("direct " + r);

            int newx = x, newy = y;
            switch (direct) {
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
            } else {
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
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}

