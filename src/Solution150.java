public class Solution150 {

    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public int removeElement2(int[] nums, int val) {
        int j = nums.length - 1;
        int i = 0;

        if (nums.length == 0) {
            return nums.length;
        }

        while (j > 0 && nums[j] == val) {
            j--;
        }
        while (i < nums.length && nums[i] != val) {
            i++;
        }

        while (i < j) {
            int a = nums[i];
            nums[i] = nums[j];
            nums[j] = a;
            while (nums[j] == val) {
                j--;
            }
            while (nums[i] != val) {
                i++;
            }
        }

        return i;
    }
}
