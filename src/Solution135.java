import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        assignCandyRight(candies, ratings, 0);

        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }

        return sum;
    }

    private void assignCandyRight(int[] candyScheme, int[] ratings, int j) {
        if (candyScheme.length == 1) {
            candyScheme[0] = 1;
        }

        if (j == ratings.length - 1) {
            // rightmost
            if (ratings[j] > ratings[j - 1]) {
                assignCandyLeft(candyScheme, ratings, j - 1);
                candyScheme[j] = candyScheme[j - 1] + 1;
            } else {
                candyScheme[j] = 1;
            }
        } else {

//            if (j == 0) {
//                // leftmost
//                if (ratings[j] > ratings[j + 1]) {
//                    assignCandy(candyScheme, ratings, j + 1);
//                    candyScheme[j] = candyScheme[j + 1] + 1;
//                } else {
//                    candyScheme[j] = 1;
//                }
//            } else {


            assignCandyRight(candyScheme, ratings, j + 1);

            if (ratings[j] > max(ratings[j + 1], ratings[j - 1])) {
                candyScheme[j] = max(candyScheme[j + 1], candyScheme[j - 1]) + 1;
            }
            if (ratings[j] < min(ratings[j + 1], ratings[j - 1])) {
                candyScheme[j] = 1;
            } else {
                candyScheme[j] = min(candyScheme[j + 1], candyScheme[j - 1]) + 1;
            }

            assignCandyLeft(candyScheme, ratings, j - 1);

        }
    }

    private void assignCandyLeft(int[] candyScheme, int[] ratings, int j) {
        if (candyScheme.length == 1) {
            candyScheme[0] = 1;
        }

        if (j == 0) {
            // rightmost
            if (ratings[j] > ratings[j + 1]) {
                assignCandyLeft(candyScheme, ratings, j - 1);
                candyScheme[j] = candyScheme[j + 1] + 1;
            } else {
                candyScheme[j] = 1;
            }
        } else {

//            if (j == 0) {
//                // leftmost
//                if (ratings[j] > ratings[j + 1]) {
//                    assignCandy(candyScheme, ratings, j + 1);
//                    candyScheme[j] = candyScheme[j + 1] + 1;
//                } else {
//                    candyScheme[j] = 1;
//                }
//            } else {


            assignCandyLeft(candyScheme, ratings, j - 1);

            if (ratings[j] > max(ratings[j + 1], ratings[j - 1])) {
                candyScheme[j] = max(candyScheme[j + 1], candyScheme[j - 1]) + 1;
            }
            if (ratings[j] < min(ratings[j + 1], ratings[j - 1])) {
                candyScheme[j] = 1;
            } else {
                candyScheme[j] = min(candyScheme[j + 1], candyScheme[j - 1]) + 1;
            }

            assignCandyRight(candyScheme, ratings, j + 1);

        }

    }


    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        Solution135 s = new Solution135();
        int b = s.candy(a);
        System.out.println(b);
    }
}


