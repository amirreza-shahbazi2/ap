import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = sc.nextInt();
        int sum = 0;
        while (number != 0) {
           int n = number % 10;
            if(n % 2 != 0) {
                sum +=n ;
            }
            number = number / 10;
        }
        System.out.println("sum="+sum);
    }
}