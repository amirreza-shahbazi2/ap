package ap.exercises.EX5;
import  java.util.ArrayList;
import java.util.List;
public class Main_EX5 {

    public class ObjectCounter {

        private List<String> items;
        private List<Integer> counts;

        public ObjectCounter() {
            this.items = new ArrayList<>();
            this.counts = new ArrayList<>();
        }

        public void add(String item) {
            int index = indexOf(item);
            if (index != -1) {
                counts.set(index, counts.get(index) + 1);
            } else {
                items.add(item);
                counts.add(1);
            }
        }

        public List<String> getTop(int k) {
            List<String> result = new ArrayList<>();
            List<String> tempItems = new ArrayList<>(items);
            List<Integer> tempCounts = new ArrayList<>(counts);

            for (int i = 0; i < k; i++) {
                int maxIndex = getMaxIndex(tempCounts);
                if (maxIndex == -1) break;

                result.add(tempItems.get(maxIndex) + " -> " + tempCounts.get(maxIndex));
                tempCounts.set(maxIndex, -1);
            }

            return result;
        }

        private int indexOf(String item) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(item)) {
                    return i;
                }
            }
            return -1;
        }

        private int getMaxIndex(List<Integer> list) {
            int maxIndex = -1;
            int max = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
}
