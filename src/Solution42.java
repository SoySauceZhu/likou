import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution42 {
    public int trap(int[] height) {
        int[] preHighest = new int[height.length];
        int[] postHighest = new int[height.length];
        preHighest[0] = 0;
        postHighest[height.length - 1] = 0;
        int pre = 0;
        int pos = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > pre) {
                preHighest[i] = height[i - 1];
                pre = height[i - 1];
            } else {
                preHighest[i] = pre;
            }

            int j = height.length - 1 - i;

            if (height[j + 1] > pos) {
                postHighest[j] = height[j + 1];
                pos = height[j + 1];
            } else {
                postHighest[j] = pos;
            }
        }

        int water = 0;

        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(preHighest[i], postHighest[i]) - height[i];
            if (temp > 0) water += temp;
        }

        return water;
    }


    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        Solution42 solution42 = new Solution42();
        int trap = solution42.trap(height);
        System.out.println(trap);
    }
}
