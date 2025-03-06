import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        System.out.println("enter count of numbers");
        int n = sc.nextInt();
        System.out.println("enter the numbers");
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number < smallest) {
                smallest = number;
            } else if (number > largest) {
                largest = number;
            }
        }
        System.out.println("smallest number is = " + smallest);
        System.out.println("largest number is = " + largest);



    }
}