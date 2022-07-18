package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight_406 {
    public static int[][] reconstructQueue(int[][] people) {
        // step 1: 身高 高到低 排序
        Arrays.sort(people, (e1, e2) -> {
            if (e1[0] > e2[0]) {
                return -1;
            }
            if (e1[0] < e2[0]) {
                return 1;
            }
            if (e1[0] == e2[0]) {
                if (e1[1] < e2[1]) {
                    return -1;
                }
                if (e1[1] > e2[1]) {
                    return 1;
                }
            }
            return 0;
        });

        for (int i = 0; i < people.length; i++) {
            System.out.print("[" + people[i][0] + "," + people[i][1] + "], ");
        }
        System.out.println();

        // step 2: 根據people[i][1] 調整位置
        int[] temp = null;
        for (int i = 1; i < people.length; i++) {
            int taller = people[i][1];
            int height = people[i][0];

            if (i > taller) {

                temp = people[i];
                for (int j = i; j > taller; j--) {
                    people[j] = people[j - 1];
                }
                people[taller] = temp;

                System.out.println("swap index: " + i + " <-> " + taller);
                for (int p = 0; p < people.length; p++) {
                    System.out.print("[" + people[p][0] + "," + people[p][1] + "], ");
                }
                System.out.println();
            }
        }

        return people;
    }

    public static void main(String[] args) {
        // [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
        int[][] ans = reconstructQueue(new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}});

        for (int i = 0; i < ans.length; i++) {
            System.out.print("[" + ans[i][0] + "," + ans[i][1] + "], ");
        }
        System.out.println();
    }
}
