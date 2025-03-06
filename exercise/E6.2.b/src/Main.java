import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evencount = 0;
        int oddcount = 0;
        System.out.println("enter count of numbers");
        int n = sc.nextInt();
        System.out.println("enter the numbers");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num % 2 == 0) {
                evencount++;
            }
            else
                oddcount++;
        }
        System.out.println("evencount: " + evencount
        + " oddcount: " + oddcount);

    }
}