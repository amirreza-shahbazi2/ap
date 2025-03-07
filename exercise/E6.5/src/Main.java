import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class DataSet {
    private List<Double> values;
    public DataSet() {
        values = new ArrayList<>();
    }
    public void add(double value) {
        values.add(value);
    }
    public double avg() {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }
    public double Smallest() {
        double smallest = values.get(0);
        for (double value : values) {
            if (value < smallest) {
                smallest = value;
            }
        }
        return smallest;
    }
    public double Largest() {
        double largest = values.get(0);
        for (double value : values) {
            if (value > largest) {
                largest = value;
            }
        }
        return largest;
    }
    public double Range() {
        return Largest() - Smallest();
    }
}
public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a set of floating-point values(enter -1 for exit):");
        while (true) {
            double value = scanner.nextDouble();
            if (value == -1) {
                break;
            }
            dataSet.add(value);
        }
        System.out.println("Average: " + dataSet.avg());
        System.out.println("Smallest: " + dataSet.Smallest());
        System.out.println("Largest: " + dataSet.Largest());
        System.out.println("Range: " + dataSet.Range());
        scanner.close();
    }
}
