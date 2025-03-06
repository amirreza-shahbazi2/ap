import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String output = input.replaceAll("[aeiouAEIOU]", "_");
        System.out.println(output);

        scanner.close();
    }
}