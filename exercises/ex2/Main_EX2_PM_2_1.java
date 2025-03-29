package exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_2_1 {
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
        int x=1, y=1;
        board[x][y]= 'X';

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
