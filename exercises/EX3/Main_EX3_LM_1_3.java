package exercises.EX3;

public class Main_EX3_LM_1_3 {
    public static Student searchbyname(String firstname, String lastname, Student[] students){
        for (Student student : students) {
            if (student.getFirstname().equalsIgnoreCase(firstname) &&
                    student.getLastname().equalsIgnoreCase(lastname)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("reza", "rezaei", "967543761", "computer science"),
                new Student("ali", "shahbazi", "254859714", "electrical engineering")
        };
        Student F=searchbyname("reza","rezaei",students);
        if(F!=null){
            System.out.println("student found \n"+F.getFirstname()+ F.getLastname());
        }
        else{
            System.out.println("student not found");
        }
    }
}
