package exercises.ex4;

public class Main_EX4_E3_4 {

    public static class Circuit {
        private int firstswitch;
        private int secondswitch;
        private int lampstate;

        public Circuit() {
            firstswitch = 0;
            secondswitch = 0;
            lampstate = 0;
        }

        public int getFirstSwitchState() {
            return firstswitch;
        }

        public int getSecondSwitchState() {
            return secondswitch;
        }

        public int getLampState() {
            return lampstate;
        }

        public void toggleFirstSwitch() {
            firstswitch = 1 - firstswitch;
            updatelamptstate();
        }

        public void toggleSecondSwitch() {
            secondswitch = 1 - secondswitch;
            updatelamptstate();
        }

        public void updatelamptstate() {
            if (firstswitch != secondswitch) {
                lampstate = 1;
            } else {
                lampstate = 0;
            }
        }

        public static void main(String[] args) {
            Circuit light = new Circuit();
            System.out.println("switch1: " + light.getFirstSwitchState());
            System.out.println("switch2: " + light.getSecondSwitchState());
            System.out.println("light state: " + light.getLampState());

            System.out.println("toggle first switch");
            light.toggleFirstSwitch();
            System.out.println("switch1:" + light.getFirstSwitchState());
            System.out.println("switch2: " + light.getSecondSwitchState());
            System.out.println("light state: " + light.getLampState());

            System.out.println("toggle second switch");
            light.toggleSecondSwitch();
            System.out.println("switch1: " + light.getFirstSwitchState());
            System.out.println("switch2: " + light.getSecondSwitchState());
            System.out.println("light state: " + light.getLampState());
        }
   }
}



