import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int last = 0;
        char[] array = s.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            int num = map.get(array[i]);
            if (num >= last) {
                sum += num;
                last = num;
            } else {
                sum -= num;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        String s = "MCMXCIV";

        System.out.println(solution13.romanToInt(s));
    }
}
