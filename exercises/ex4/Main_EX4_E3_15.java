package exercises.ex4;

public class Main_EX4_E3_15 {
    public static class Letter{
        private String form;
        private String to;
        public String body;

        public Letter(String form, String to){
            this.form = form;
            this.to = to;
            body = "";
        }
        public void addLine(String line){
            body=body.concat(line).concat("\n");

        }
        public String getText(){
            String letter="Dear"+to+": \n";
            letter=letter.concat(body);
            letter=letter.concat("Sincerely,\n");
            letter=letter.concat(form);
            return letter;
        }
    }
    public static class LetterPrinter{
        public static void main(String[] args) {
            Letter letter=new Letter("Mary","John");
            letter.addLine("I am sorry we must part.");
            letter.addLine("I wish you all the best.");
            System.out.println(letter.getText());
        }
    }
}
