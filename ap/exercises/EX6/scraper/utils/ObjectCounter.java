package ap.exercises.EX6.scraper.utils;



import java.util.*;
//
//public class ObjectCounter <E> {
//
//    private Map<E,Integer> counterMap;
//
//    public ObjectCounter() {
//        this.counterMap=new HashMap<>();
//    }
//
//    public void add(E item){
//        if (this.counterMap.containsKey(item)){
//            this.counterMap.put(item, this.counterMap.get(item)+1);
//        }
//        else{
//            this.counterMap.put(item,1);
//        }
//    }
//
//    public List<Map.Entry<E, Integer>> getTop(int k){
//        return this.counterMap.entrySet().stream()
//                .sorted((a,b) -> -a.getValue().compareTo(b.getValue()))
//                .limit(k)
//                .collect(Collectors.toList());
//    }
//}

//
//import  java.util.ArrayList;
//import java.util.List;
//
//public class ObjectCounter {
//
//    private List<String> items; // لیست رشته‌ها
//    private List<Integer> counts; // لیست تعداد تکرارها
//
//    public ObjectCounter() {
//        this.items = new ArrayList<>();
//        this.counts = new ArrayList<>();
//    }
//
//    // اضافه کردن یک رشته
//    public void add(String item) {
//        int index = indexOf(item);
//        if (index != -1) {
//            counts.set(index, counts.get(index) + 1);
//        } else {
//            items.add(item);
//            counts.add(1);
//        }
//    }
//
//    // پیدا کردن top k آیتم پر تکرار
//    public List<String> getTop(int k) {
//        List<String> result = new ArrayList<>();
//        List<String> tempItems = new ArrayList<>(items);
//        List<Integer> tempCounts = new ArrayList<>(counts);
//
//        for (int i = 0; i < k; i++) {
//            int maxIndex = getMaxIndex(tempCounts);
//            if (maxIndex == -1) break;
//
//            result.add(tempItems.get(maxIndex) + " -> " + tempCounts.get(maxIndex));
//            tempCounts.set(maxIndex, -1); // علامت‌گذاری به عنوان بررسی‌شده
//        }
//
//        return result;
//    }
//
//    // پیدا کردن ایندکس یک آیتم در لیست
//    private int indexOf(String item) {
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).equals(item)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    // پیدا کردن ایندکس بیشترین مقدار در counts
//    private int getMaxIndex(List<Integer> list) {
//        int maxIndex = -1;
//        int max = -1;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) > max) {
//                max = list.get(i);
//                maxIndex = i;
//            }
//        }
//        return maxIndex;
//    }
//}




//import java.util.ArrayList;
//import java.util.List;
//
//public class ObjectCounter {
//
//    private static class Entry {
//        String item;
//        int count;
//
//        Entry(String item, int count) {
//            this.item = item;
//            this.count = count;
//        }
//    }
//
//    private List<Entry> counterList;
//
//    public ObjectCounter() {
//        this.counterList = new ArrayList<>();
//    }
//
//    public void add(String item) {
//        for (Entry entry : counterList) {
//            if (entry.item.equals(item)) {
//                entry.count++;
//                return;
//            }
//        }
//        counterList.add(new Entry(item, 1));
//    }
//
//    public List<String> getTop(int k) {
//        // مرتب‌سازی بر اساس count به صورت نزولی
//        counterList.sort((a, b) -> Integer.compare(b.count, a.count));
//
//        List<String> topK = new ArrayList<>();
//        for (int i = 0; i < k && i < counterList.size(); i++) {
//            topK.add(counterList.get(i).item + " (" + counterList.get(i).count + ")");
//        }
//        return topK;
//    }
//}


//public class ObjectCounter<String> {
//
//    private class ItemCount {
//        String item;
//        int count;
//
//        ItemCount(String item) {
//            this.item = item;
//            this.count = 1;
//        }
//    }
//
//    private List<ItemCount> counterList;
//
//    public ObjectCounter() {
//        this.counterList = new ArrayList<>();
//    }
//
//    public void add(String item) {
//        for (ItemCount ic : counterList) {
//            if (ic.item.equals(item)) {
//                ic.count++;
//                return;
//            }
//        }
//        // اگر آیتم پیدا نشد، به لیست اضافه می‌کنیم
//        counterList.add(new ItemCount(item));
//    }
//
////    public Map.Entry<java.lang.String, Integer> getTop(int k) {
//
//        public List<String> getTop(int k) {
//        // کپی لیست برای مرتب‌سازی بدون تغییر نسخه اصلی
//        List<ItemCount> sortedList = new ArrayList<>(counterList);
//
//        // مرتب‌سازی بر اساس count به صورت نزولی
//        Collections.sort(sortedList, new Comparator<ItemCount>() {
//            @Override
//            public int compare(ItemCount o1, ItemCount o2) {
//                return Integer.compare(o2.count, o1.count);
//            }
//        });
//
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < Math.min(k, sortedList.size()); i++) {
//            result.add(sortedList.get(i).item);
//        }
//
//        return result;
//    }
//}


public class ObjectCounter<String> {

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

            result.add((String) (tempItems.get(maxIndex) + " -> " + tempCounts.get(maxIndex)));
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


