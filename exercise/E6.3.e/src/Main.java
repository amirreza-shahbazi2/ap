import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.print("Positions of vowels: ");
        for (int i = 0; i < input.length(); i++) {
            if ("aeiouAEIOU".indexOf(input.charAt(i)) != -1) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}