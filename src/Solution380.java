import java.util.*;

public class Solution380 {
    public class RandomizedSet {
        // HashMap to store value -> index mapping for O(1) lookup
        private Map<Integer, Integer> valueToIndexMap;
        // ArrayList to store actual values for O(1) random access
        private List<Integer> valuesList;
        // Random number generator for getRandom() method
        private Random random;

        public RandomizedSet() {
            valueToIndexMap = new HashMap<>();
            valuesList = new ArrayList<>();
            random = new Random();
        }


        /*
            The problem is:
            - get should be done at O(1) and random, so you need an index-able array list
            - remove should be done at O(1), but remove in array list is (usually) not O(1).
            - trick: when remove, you can avoid barrel shift by swapping the removed element
                     with last element, and delete the end.
         */

        public boolean insert(int val) {
            if (valueToIndexMap.containsKey(val)) return false;

            valueToIndexMap.put(val, valuesList.size());
            valuesList.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valueToIndexMap.containsKey(val)) return false;

            int idx = valueToIndexMap.get(val);
            valueToIndexMap.put(valuesList.get(valuesList.size() - 1), idx);
            valueToIndexMap.remove(val);
            valuesList.set(idx, valuesList.get(valuesList.size() - 1));
            valuesList.remove(valuesList.size() - 1);

            return true;
        }

        public int getRandom() {
            int rand = random.nextInt(valuesList.size());
            return valuesList.get(rand);
        }
    }


    public static void main(String[] args) {
        Solution380 solution380 = new Solution380();
        Solution380.RandomizedSet randomizedSet = solution380.new RandomizedSet();

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
