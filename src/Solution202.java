import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {

        Set<Integer> occurrence = new HashSet<>();

        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;

            if (occurrence.contains(n)) return false;
            occurrence.add(n);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution202 s = new Solution202();

        int[] tests = {1, 7, 19, 2, 20, 1111111, 2147483647};
        for (int n : tests) {
            System.out.println(n + " -> " + s.isHappy(n));
        }
    }
//        1 -> true
//        7 -> false
//        19 -> false
//        2 -> false
//        20 -> false
//        1111111 -> false
//        2147483647 -> false
}
