package exercises.ex4;

public class Main_EX4_E3_12 {
    public static class Employee {
        private String name;
        private double salary;

        public Employee(String employeeName, double currentSalary) {
            name = employeeName;
            salary = currentSalary;

        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public void raiseSalary(double byPercent) {
            salary += byPercent * salary / 100;
        }

    }

    public static class EmployeeTester {

        public static void main(String[] args) {
            Employee harry = new Employee("Hacker,Harry", 1000);
            System.out.println("Employee Name: " + harry.getName());
            System.out.println("Employee Salary: " + harry.getSalary());


            harry.raiseSalary(10);
            System.out.println("after 10% raiseSalary: " + harry.getSalary());
            double currentSalary = harry.getSalary();

            harry.raiseSalary(0);
            System.out.println("Employee Name: " + harry.getName());
            System.out.println("after 0% raiseSalary: " + harry.getSalary());

            if (harry.getSalary() == currentSalary) {
                System.out.println("test passed");
            } else {
                System.out.println("test failed");
            }

        }

    }
}

