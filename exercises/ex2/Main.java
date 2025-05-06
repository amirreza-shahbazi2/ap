package exercises.ex2;

import java.util.ArrayList;
public class Main{

 public static class book{
    private String title;
    private double price;
    public book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}
public static class pen{
     private String color;
     private String brand;
     private double price;
     public pen(String color, String brand, double price) {
         this.color = color;
         this.brand = brand;
         this.price = price;

     }

}


     public static void main(String[] args) {
         ArrayList<book> books = new ArrayList<book>();
         ArrayList<pen> pens = new ArrayList<pen>();
         book book1 = new book("Book 1", 10.0);
         books.add(book1);
         book book2 = new book("Book 2", 20.0);
         books.add(book2);

         pen pen1=new pen("red","d",1000);
         pens.add(pen1);
         pen pen2=new pen("blue","d",2000);
         pens.add(pen2);

         for (book b : books) {
             System.out.println(b.title);
             System.out.println(b.price);
         }
         for (pen p : pens) {
             System.out.println(p.color);
             System.out.println(p.brand);
             System.out.println(p.price);

         }

     }
}
