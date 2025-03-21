import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] possibleArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");


        for (int sub : possibleArr) {
            while (num >= sub) {
                num -= sub;
                sb.append(map.get(sub));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int num = 3749;
        System.out.println(solution12.intToRoman(num));
    }
}
