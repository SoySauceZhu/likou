import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;

public class Solution135 {

    public int candy(int[] ratings) {
        // if rating[i] > rating [i-1], increment by 1 to # candy of [i-1]
        // if rating[i] <= rating [i-1], the greedy capitalist will cut the candy to minimum, since it doesn't break the rule
        int[] preArray = new int[ratings.length];
        preArray[0] = 1;
        int[] posArray = new int[ratings.length];
        posArray[ratings.length - 1] = 1;

        for (int i = 1; i < preArray.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                preArray[i] = preArray[i - 1] + 1;
            } else {
//                preArray[i] = Math.max(1, preArray[i - 1] - 1);
                preArray[i] = 1;
            }

            int j = preArray.length - 1 - i;
            if (ratings[j] > ratings[j + 1]) {
                posArray[j] = posArray[j + 1] + 1;
            } else {
                posArray[j] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(posArray[i], preArray[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] ratings = {1,2,3,4,5,3,1,2,2,1};

        int[] ratings = {1, 2, 3,3,3, 2, 1, 0};


        Solution135 solution135 = new Solution135();
        int candy = solution135.candy(ratings);
        System.out.println(candy);
    }

}


//
//public int candy(int[] ratings) {
//    int[] candies = new int[ratings.length];
//    Arrays.fill(candies, 1);
//
//    if (ratings.length == 1) {
//        return 1;
//    }
//
//    for (int i = 0; i < ratings.length - 1; i++) {
//        if (ratings[i] < ratings[i + 1]) {
//            candies[i + 1] = max(candies[i] + 1, candies[i + 1]);
//        }
//    }
//
//    for (int j = ratings.length - 1; j > 0; j--) {
//        if (ratings[j - 1] > ratings[j]) {
//            candies[j - 1] = max(candies[j] + 1, candies[j - 1]);
//        }
//    }
//
//    int sum = 0;
//    for (int i : candies) {
//        sum += i;
//    }
//
//    return sum;
//}