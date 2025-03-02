import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your income");
        int income = sc.nextInt();
        float tax=0;
        if (income < 50000) {
             tax = (float) (1 * income) /100;
        } else if (income < 75000 && income>50000) {
             tax = (float) (2 * income) /100;
        } else if (income < 100000 && income>75000) {
             tax = (float) (3 * income) /100;
        } else if (income < 250000 && income>100000) {
             tax = (float) (4 * income) /100;
        } else if (income < 500000 && income>250000) {
             tax = (float) (5 * income) /100;
        }
        else if (income > 500000 ) {
             tax = (float) (6 * income) /100;
        }
        System.out.println("tax ="+tax );

    }
}