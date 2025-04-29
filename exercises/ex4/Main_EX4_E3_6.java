package exercises.ex4;

public class Main_EX4_E3_6 {

    public static class Circuit {
        private int switchstates;
        private int lampStates;

        public Circuit() {
            switchstates = 0;
            lampStates = 0;
        }

        public int getSwitchstates(int switchNum) {
            if (switchNum == 1) {
                return switchstates & 1;
            } else if (switchNum == 2) {
                return (switchstates >> 1) & 1;

            } else {
                throw new IllegalArgumentException("Invalid switch number: " + switchNum);
            }

        }

        public int getLampState() {
            if ((switchstates & 1) != ((switchstates >> 1) & 1)) {
                lampStates = 1;
            } else {
                lampStates = 0;
            }
            return lampStates;

        }

        public void toggleSwitch(int switchNum) {
            if (switchNum == 1) {
                switchstates ^= 1;
            } else if (switchNum == 2) {
                switchstates ^= (1 << 1);
            } else {
                throw new IllegalArgumentException("Invalid switch number: " + switchNum);
            }
        }

        public static void main(String[] args) {
            Circuit light2 = new Circuit();
            System.out.println("switch1: " + light2.getSwitchstates(1));
            System.out.println("switch2:" + light2.getSwitchstates(2));
            System.out.println("lampState: " + light2.getLampState());

            System.out.println("toggleSwitch(1): ");
            light2.toggleSwitch(1);
            System.out.println("switch1: " + light2.getSwitchstates(1));
            System.out.println("switch2: " + light2.getSwitchstates(2));
            System.out.println("lampState: " + light2.getLampState());

            System.out.println("\nToggleswitch 2:");
            light2.toggleSwitch(2);
            System.out.println("switch 1: " + light2.getSwitchstates(1));
            System.out.println("switch 2: " + light2.getSwitchstates(2));
            System.out.println("lampState: " + light2.getLampState());
        }
    }


}
