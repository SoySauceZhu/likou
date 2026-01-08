import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution380 {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    public Solution380() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int i = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(i, last);
        list.set(list.size() - 1, null);
        map.remove(val);
        map.put(last, i);
        return true;
    }

    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        Solution380 randomizedSet = new Solution380();

        // Test insert
        System.out.println("Insert 1: " + randomizedSet.insert(1)); // true
        System.out.println("Insert 2: " + randomizedSet.insert(2)); // true
        System.out.println("Insert 3: " + randomizedSet.insert(3)); // true
        System.out.println("Insert 1 again: " + randomizedSet.insert(1)); // false (already exists)

        // Test getRandom
        System.out.println("Random element: " + randomizedSet.getRandom()); // 1, 2, or 3

        // Test remove
        System.out.println("Remove 2: " + randomizedSet.remove(2)); // true
        System.out.println("Remove 2 again: " + randomizedSet.remove(2)); // false (already removed)

        // Check getRandom after removal
        System.out.println("Random element after removal: " + randomizedSet.getRandom()); // Should be 1 or 3

        // Insert again
        System.out.println("Insert 4: " + randomizedSet.insert(4)); // true
        System.out.println("Insert 5: " + randomizedSet.insert(5)); // true

        // Remove another element
        System.out.println("Remove 1: " + randomizedSet.remove(1)); // true

        // Final Random test
        System.out.println("Final Random: " + randomizedSet.getRandom()); // Should be 3, 4, or 5
    }
}
