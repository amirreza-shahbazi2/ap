import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three strings: ");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        String [] strArr = {str1, str2, str3};
        for(int i = 0; i<strArr.length; i++){
            for(int j = 0; j<strArr.length-i-1; j++){
                if(strArr[j].compareTo(strArr[j+1]) >0){
                    String temp = strArr[j];
                    strArr[j] = strArr[j+1];
                    strArr[j+1] = temp;
                }
            }
        }
        for(int i = 0; i<strArr.length;i++){
            System.out.println(strArr[i]);
        }
    }
}