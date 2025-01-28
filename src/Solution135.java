import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class Solution135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        if (ratings.length == 1) {
            return 1;
        }

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = max(candies[i] + 1, candies[i + 1]);
            }
        }

        for (int j = ratings.length - 1; j > 0; j--) {
            if (ratings[j - 1] > ratings[j]) {
                candies[j - 1] = max(candies[j] + 1, candies[j - 1]);
            }
        }

        int sum = 0;
        for (int i : candies) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] ratings = {1,2,3,4,5,3,1,2,2,1};

        int[] ratings = {1, 0, 2};


        Solution135 solution135 = new Solution135();
        int candy = solution135.candy(ratings);
        System.out.println(candy);
    }

}