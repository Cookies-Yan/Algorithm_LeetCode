package leetCode.greedy_16;

import java.util.Arrays;

/**
 * Time O(n)
 * Space O(n)
 */
public class H_135_Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }

        }

        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                /**
                 * 不这么写， {1, 2, 87, 87, 2, 1}这个test case 过不去
                 */
                candies[j] = Math.max(candies[j], candies[j + 1] + 1);

            }
        }

        int res = 0;
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }
}
