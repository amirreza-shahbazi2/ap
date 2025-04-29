package exercises.ex4;

public class Main_EX4_E3_10 {
    public static class CashRegister {
        private double total;
        private String itemlist;

        public CashRegister() {
            this.total = 0;
            this.itemlist = "";
        }

        public void add(double price) {
            total += price;
            if (itemlist.isEmpty()) {
                itemlist = String.valueOf(price);
            } else {
                itemlist = itemlist.concat(", ").concat(String.valueOf(price));
            }

        }

        public double getTotal() {
            return total;
        }

        public void printReceipt() {
            System.out.println("receipt ");
            System.out.println("itemlist: " + itemlist);
            System.out.println("total price : " + total);
        }


        public static void main(String[] args) {
            CashRegister reg = new CashRegister();

            reg.add(1.22);
            reg.add(2.54);
            reg.add(3.22);

            reg.printReceipt();
        }
    }
}