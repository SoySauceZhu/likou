public class Solution11 {

    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int base = right - left;

            // maxWater of longer base has already been tested.
            // Why should you move the lower height pointer:
            // because base is shortened no matter which pointer you move
            // meanwhile, the area = lower * base.
            // So you can only expect the lower height will increase.

            // more higher height won't increase the area

            if (height[left] <= height[right]) {
                maxWater = Math.max(base * height[left], maxWater);
                left++;
            } else {
                maxWater = Math.max(base * height[right], maxWater);
                right--;
            }
        }

        return maxWater;
    }


    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(height);
        System.out.println("The maximum area is: " + result);
    }

}
//
//public int maxArea(int[] height) {
//    int maxArea = 0;
//    int left = 0;
//    int right = height.length;
//
//    while (left < right) {
//        int area = (right - left - 1) * Math.min(height[left], height[right - 1]);
//        maxArea = Math.max(maxArea, area);
//
//
//        // Move the pointer with the smaller height inward
//        // (why? because the area is limited by the shorter line;
//        //  moving it might help increase height).
//        if (height[left] < height[right - 1]) {
//            left++;
//        } else {
//            right--;
//        }
//    }
//
//    return maxArea;
//}
//
