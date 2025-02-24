import java.util.Arrays;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int suf = 1;

        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * pre;
            pre = pre * nums[i];
        }

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = res[i] * suf;
            suf = suf * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution238 solution238 = new Solution238();
        System.out.println(Arrays.toString(solution238.productExceptSelf(nums)));
    }
}
