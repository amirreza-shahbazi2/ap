package exercises.ex4;

import exercises.ex4.Main_EX4_E3_4.Circuit;

public class Main_EX4_E3_5 {

    public static void main(String[] args) {

        Circuit circuit = new Circuit();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 1) {
                    circuit.toggleFirstSwitch();
                }
                if (j == 1) {
                    circuit.toggleSecondSwitch();
                }
                int first = circuit.getFirstSwitchState();
                int second = circuit.getSecondSwitchState();
                int lamp = circuit.getLampState();
                int exepted = (first != second) ? 1 : 0;

                System.out.println("first=" + first + " second=" + second + " lamp=" + lamp + " exepted=" + exepted);

                if (i == 1) {
                    circuit.toggleFirstSwitch();
                }
                if (j == 1) {
                    circuit.toggleSecondSwitch();
                }
            }
        }
    }
}
