import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final float g = 9.8F;
        System.out.println("enter the value of mass ");
        float mass = sc.nextFloat();
        System.out.println("enter the value of height ");
        float height = sc.nextFloat();
        float u= mass*g*height;
        System.out.println("u is "+u);

    }
}
