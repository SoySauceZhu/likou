import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            list.add(i);
        }

        helper(list);
        return result;
    }

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> builder = new ArrayList<>();

    private void helper(List<Integer> restElements) {
        if (restElements.isEmpty()) {
            result.add(new ArrayList<>(builder));
            return;
        }

        for (int i = 0; i < restElements.size(); i++) {
            builder.add(restElements.remove(i));
            helper(restElements);
            restElements.add(i, builder.remove(builder.size() - 1));
        }
    }

    public static void main(String[] args) {
        Solution46 s = new Solution46();

        int[] nums1 = {1, 2, 3};
        List<List<Integer>> perms1 = s.permute(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Count: " + perms1.size());
        System.out.println(perms1);

        Solution46 s2 = new Solution46();
        int[] nums2 = {0, 1};
        List<List<Integer>> perms2 = s2.permute(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Count: " + perms2.size());
        System.out.println(perms2);

        Solution46 s3 = new Solution46();
        int[] nums3 = {1};
        List<List<Integer>> perms3 = s3.permute(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Count: " + perms3.size());
        System.out.println(perms3);
    }
}
