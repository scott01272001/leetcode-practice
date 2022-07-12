package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NonOverlappingIntervals_435 {

    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (e1, e2) -> {
            if (e1[1] < e2[1]) {
                return -1;
            }
            if (e1[1] > e2[1]) {
                return 1;
            }
            return 0;
        });

        int remove = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                remove++;
            } else {
                prevEnd = intervals[i][1];
            }
        }


        return remove;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1, 100}, {11, 22}, {1, 11}, {2, 12}};

    }

}
