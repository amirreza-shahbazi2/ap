import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the diamond: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int k = n - i - 1; k > 0; k--)
                System.out.print(" ");
            for (int j = 0; j < (2 * i+1) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int k = n - i - 1; k > 0; k--)
                System.out.print(" ");
            for (int j = 0; j < (2 *i+1) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}