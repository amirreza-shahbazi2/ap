import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter count of numbers");
        int n = sc.nextInt();
        System.out.println("enter the numbers");
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            System.out.println("cumulative total:");
            sum = sum + arr[i];
            System.out.println(sum + " ");
        }
    }
}