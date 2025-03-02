
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number");
        double num  = sc.nextDouble();
        if (num == 0) {
            System.out.println("zero");
        } else if (num < 0) {
            System.out.println("negative + small");
        } else if (num > 0) {
            if (num < 1) {
                System.out.println("positive + small");
            } else if (num > 1000000) {
                System.out.println("positive + big");
            } else
                System.out.println("positive");
        }
     sc.close();

    }
}