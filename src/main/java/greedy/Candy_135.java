package greedy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Candy_135 {

    public static int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                if (candies[j] <= candies[j + 1]) {
                    candies[j] = candies[j + 1] + 1;
                }
            }
        }

        int sum = 0;
        for (int i : candies) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        int ans = candy(new int[] {1, 2, 87, 87, 87, 2, 1});
        System.out.println(ans);
    }

}
