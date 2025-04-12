public class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length;

        while (left < right) {
            int area = (right - left - 1) * Math.min(height[left], height[right - 1]);
            maxArea = Math.max(maxArea, area);


            // Move the pointer with the smaller height inward
            // (why? because the area is limited by the shorter line;
            //  moving it might help increase height).
            if (height[left] < height[right - 1]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(height);
        System.out.println("The maximum area is: " + result);
    }

}
