package exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a character(w/a/s/d/q)");
            char ch = sc.next().charAt(0);
            switch (ch) {
                case 'w':
                    System.out.println("UP");
                    break;
                case 's':
                    System.out.println("DOWN");
                    break;
                case 'a':
                    System.out.println("LEFT");
                    break;
                case 'd':
                    System.out.println("RIGHT");
                    break;
                case 'q':
                    System.out.println("EXIT");
                    System.exit(0);
                default :
                    System.out.println("WARNING");
            }
        }
    }
}


