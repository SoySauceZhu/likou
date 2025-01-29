import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution42 {

    // I think the suggested solution is much better than mine

    /*
        public int trap(int[] height) {
		int n = height.length;
		if (n < 3) return 0;
		int[] prefixMax = new int[n];
		int[] suffixMax = new int[n];
		prefixMax[0] = height[0];
		suffixMax[n-1] = height[n-1];
		for (int i=1; i<n; i++) {
			prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
		}
		for (int i=n-2; i>=0; i--) {
			suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
		}
		int currMin, answer = 0;
		for (int i=0; i<n; i++) {
			currMin = Math.min(prefixMax[i], suffixMax[i]);
			if (height[i] < currMin) answer += (currMin - height[i]);
		}
		return answer;
	}
     */

    public int trap(int[] height) {
        int[] water1 = new int[height.length];
        int[] water2 = new int[height.length];
        int[] water = new int[height.length];

        for (int start = 0; start < height.length - 1; start++) {
            int end = start + 1;
            int level = height[start];
            while (end < height.length && height[end] < level) {
                end++;
            }
            fillWater(height, water1, level, start, end);

            start = end - 1;

            // The for loop will update the variable at THIS LINE !!!
        }

        for (int end = height.length - 1; end > 0; end--) {
            int start = end - 1;
            int level = height[end];
            while (start > 0 && height[start] < level) {
                start--;
            }
            fillWater(height, water2, level, start, end);
            end = start + 1;
        }

        for (int i = 0; i < water1.length; i++) {
            water[i] = min(water1[i], water2[i]);
        }

        int sum = 0;
        for (int j : water) {
            sum += j;
        }
        return sum;
    }

    private void fillWater(int[] height, int[] water, int level, int start, int end) {
        for (int i = start; i < end; i++) {
            water[i] = max(level - height[i], water[i]);
        }
    }

    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,4,3,4};
        Solution42 solution42 = new Solution42();
        int trap = solution42.trap(height);
        System.out.println(trap);
    }
}
