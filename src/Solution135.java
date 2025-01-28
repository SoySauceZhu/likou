public class Solution135 {
    public int candy(int[] ratings) {
        for (int i = 0; i < ratings.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ratings.length; j++) {
                if (ratings[j] < ratings[minIndex]) {
                    minIndex = j;
                }

                int temp = ratings[j];
                ratings[j] = ratings[minIndex];
            }
        }

        int num = 0;
        int lastCandy = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num += lastCandy + 1;
            }
            if (ratings[i] < ratings[i - 1]) {

            }
        }


        return num;
    }
}