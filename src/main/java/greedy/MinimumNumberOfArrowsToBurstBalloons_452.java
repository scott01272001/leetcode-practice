package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfArrowsToBurstBalloons_452 {

    public static int findMinArrowShots(int[][] points) {
        // step 1: sort by first element
        Arrays.sort(points, (e1, e2) -> {
            if (e1[1] < e2[1]) {
                return -1;
            }
            if (e1[1] > e2[1]) {
                return 1;
            }
            return 0;
        });

        int arrows = 1;

        // step 2: greedy, 一支箭要射到最多的氣球 -> 沿著邊界射, 有重疊的就會被射到
        int rightBound = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > rightBound) {
                arrows++;
                rightBound = points[i][1];
            }
        }

        // step 3: 有幾組就射幾支箭
        return arrows;
    }

    public static void main(String[] args) {
        int ans = findMinArrowShots(new int[][] {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}});
        System.out.println(ans);
    }

}
