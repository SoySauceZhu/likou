import java.util.Arrays;

public class Solution238 {


    public int[] productExceptSelf(int[] nums) {
        int[] preArray = new int[nums.length];
        int[] sufArray = new int[nums.length];

        int pre = 1;
        int suf = 1;

        for (int i = 0; i < nums.length; i++) {
            preArray[i] = pre;
            pre *= nums[i];
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            sufArray[j] = suf;
            suf *= nums[j];
        }


        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = preArray[i] * sufArray[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution238 solution238 = new Solution238();
        System.out.println(Arrays.toString(solution238.productExceptSelf(nums)));
    }
}

//
//
//
//
//
//
//
//    public int[] productExceptSelf(int[] nums) {
//        int pre = 1;
//        int suf = 1;
//
//        int[] res = new int[nums.length];
//        Arrays.fill(res, 1);
//
//        for (int i = 0; i < res.length; i++) {
//            res[i] = res[i] * pre;
//            pre = pre * nums[i];
//        }
//
//        for (int i = res.length - 1; i >= 0; i--) {
//            res[i] = res[i] * suf;
//            suf = suf * nums[i];
//        }
//
//        return res;
//    }
//
