package exercises.ex2;
import java.util.Scanner;

public class Main_EX2_PM_1_2 {
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
        for(int i=0; i<k+2; i++) {
            for(int j=0; j<k+2; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}