import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number == 0) {
            System.out.println("0");
        } else {
            while (number > 0) {
                int digit = number % 2;
                System.out.println(digit) ;
                number /= 2;
            }
        }
        scanner.close();
    }
}