import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the squares: ");
        int Length = scanner.nextInt();
        for (int i = 1; i <= Length; i++) {
            for (int j = 1; j <= Length; j++) {
                System.out.print("*");
            }
            System.out.print(" ");
            for (int j = 1; j <= Length; j++) {
                if (i == 1 || i == Length || j == 1 || j == Length) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
