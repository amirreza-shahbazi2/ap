import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integers (type 'exit' to stop):");

        List<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).equals(numbers.get(i - 1))) {
                System.out.print(numbers.get(i) + " ");
            }
        }

        scanner.close();
    }
}