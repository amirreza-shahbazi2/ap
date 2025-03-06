import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        for (int i = 0; i < word.length(); i++) {
            // Print each character on a new line
            System.out.println(word.charAt(i));
        }


        scanner.close();
    }
}
